package ie.atu.sem2.project_atlas_history_log.projectatlas_achievementlog.WorkoutAchievementService;

import ie.atu.sem2.project_atlas_history_log.projectatlas_achievementlog.WorkoutAchievementModel.WorkoutAchievementModel;
import ie.atu.week5.projectatlas.ExerciseSelectionService.ExerciseSelectionService;
import ie.atu.week5.projectatlas.WorkoutAchievment.WorkoutAchievemt;
import ie.atu.week5.projectatlas.WorkoutPlanService.WorkoutPlanService;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkoutAchievementService {
    private final List<WorkoutAchievement> achievements = new ArrayList<>();
    private long nextId = 1;

    private final ExerciseSelectionService exerciseSelectionService;
    private final WorkoutPlanService workoutPlanService;
    private final RestTemplate restTemplate;

    private static final String HISTORY_SERVICE_URL = "http://localhost:8081/logs";
    private static final String HISTORY_RECORDS_URL = "http://localhost:8081/logs/records";

    public WorkoutAchievementService(ExerciseSelectionService exerciseSelectionService,
                                     WorkoutPlanService workoutPlanService,
                                     RestTemplate restTemplate) {
        this.exerciseSelectionService = exerciseSelectionService;
        this.workoutPlanService = workoutPlanService;
        this.restTemplate = restTemplate;
    }

    public WorkoutAchievementModel logAchievement(WorkoutAchievementModel achievement) {
        if(workoutPlanService.getWorkoutPlanById(achievement.getWorkoutPlanId()) == null) {
            throw new IllegalArgumentException("Workout Plan Not Found: " + achievement.getWorkoutPlanId());
        }

        List<String> validExercises = exerciseSelectionService.getALlExercisesFlat();
        if(!validExercises.contains(achievement.getExerciseName())) {
            throw new IllegalArgumentException("Invalid Exercise Name: " + achievement.getExerciseName());
        }

        int volume = achievement.getWeight() * achievement.getReps();
        achievement.setVolume(volume);

        int previousPR = 0;
        try{
            Integer historicPR = restTemplate.getForObject(
                    HISTORY_RECORDS_URL + "?ExerciseName = " + achievement.getExerciseName(),
                    Integer.class
            );
            if(historicPR != null)
                previousPR = historicPR;
            }
            catch (Exception e) {
                System.out.println("Error: Could Not Fetch PR From History Service || " + e.getMessage());
            }

        if (volume > previousPR) {
            achievement.setNewPR(true);
            achievement.setPRMessage("New PR For " + achievement.getExerciseName() +
                   "! | Volume: " + volume + " Previous: " + previousPR);
        } else {
            achievement.setNewPR(false);
            achievement.setPRMessage(null);
        }
        achievement.setId(nextId++);
        achievements.add(achievement);

        try {
            restTemplate.postForObject(HISTORY_SERVICE_URL, achievement, WorkoutAchievementModel.class);
        } catch (Exception e) {
            System.out.println("Error: Could Not Post To History Service || " + e.getMessage());
        }
        return achievement;
    }

    public List<WorkoutAchievementModel> getAllAchievements() {
        return new ArrayList<>(achievements);
    }

    public List<WorkoutAchievementModel> getAchievementsByExerciseName(String exerciseName) {
        return achievements.stream()
                .filter(a -> a.getExerciseName().equalsIgnoreCase(exerciseName))
                .collect(Collectors.toList());
    }
}
