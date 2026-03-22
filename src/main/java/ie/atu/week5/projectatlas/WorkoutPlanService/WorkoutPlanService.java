package ie.atu.week5.projectatlas.WorkoutPlanService;

import ie.atu.week5.projectatlas.ExerciseSelectionService.ExerciseSelectionService;
import ie.atu.week5.projectatlas.WorkoutPlan.WorkoutPlan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutPlanService {
    private final List<WorkoutPlan> workoutPlans = new ArrayList<WorkoutPlan>();
    private long nextId = 1;

    private final ExerciseSelectionService exerciseSelectionService;

    public WorkoutPlanService(ExerciseSelectionService exerciseSelectionService) {
        this.exerciseSelectionService = exerciseSelectionService;
    }

    public WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan) {
        List<String> validExercises = exerciseSelectionService.getAllExercisesFlat();

        for (WorkoutPlan.WorkoutExercise we : workoutPlan.getExercises()) {
            if(!validExercises.contains(we.getExerciseName())) {
                throw new IllegalArgumentException("Invalid Exercise Name: " + we.getExerciseName());
            }
        }
        workoutPlan.setId(nextId++);
        workoutPlans.add(workoutPlan);
        return workoutPlan;
    }
    public List<WorkoutPlan> getAllWorkoutPlans() {
        return new ArrayList<>(workoutPlans);
    }

    public WorkoutPlan getWorkoutPlanById(long id) {
        return workoutPlans.stream().filter(workoutPlan -> workoutPlan.getId() == id).findFirst().orElse(null);
    }
}
