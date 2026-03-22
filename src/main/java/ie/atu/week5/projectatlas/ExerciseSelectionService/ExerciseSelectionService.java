package ie.atu.week5.projectatlas.ExerciseSelectionService;

import ie.atu.week5.projectatlas.ExerciseSelection.ExerciseSelection;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseSelectionService {
    private final List<ExerciseSelection> exerciseSelections = new ArrayList<>();
    private long nextMuscleGroupID = 1;

    public ExerciseSelectionService() {
        ExerciseSelection chest = new ExerciseSelection();
        chest.setMuscleGroupID(nextMuscleGroupID++);
        chest.setMuscleGroup("Chest");
        chest.setExercises(List.of("Flat Bench Press", "Incline Bench Press", "Chest Fly", "Push Up"));
        exerciseSelections.add(chest);

        ExerciseSelection back = new ExerciseSelection();
        back.setMuscleGroupID(nextMuscleGroupID++);
        back.setMuscleGroup("Back");
        back.setExercises(List.of("Pull Up", "Lat Pulldown", "Deadlift", "T-Bar Row"));
        exerciseSelections.add(back);

        ExerciseSelection arms = new ExerciseSelection();
        arms.setMuscleGroupID(nextMuscleGroupID++);
        arms.setMuscleGroup("Arms");
        arms.setExercises(List.of("Barbell Curl", "Dumbbell Hammer Curl", "Preacher Curl", "Machine Tricep Pushdown", "Overhead Dumbbell Tricep Extension", "Tricep Dips"));
        exerciseSelections.add(arms);

        ExerciseSelection shoulders = new ExerciseSelection();
        shoulders.setMuscleGroupID(nextMuscleGroupID++);
        shoulders.setMuscleGroup("Shoulders");
        shoulders.setExercises(List.of("Overhead Press", "Lateral Raises"));
        exerciseSelections.add(shoulders);

        ExerciseSelection legs = new ExerciseSelection();
        legs.setMuscleGroupID(nextMuscleGroupID++);
        legs.setMuscleGroup("Legs");
        legs.setExercises(List.of("Barbell Squat", "Hack Squat", "Leg Press", "Leg Curls", "Leg Extensions", "Calf Raises"));
        exerciseSelections.add(legs);

        ExerciseSelection core = new ExerciseSelection();
        core.setMuscleGroupID(nextMuscleGroupID++);
        core.setMuscleGroup("Core");
        core.setExercises(List.of("Machine Crunch", "Cable Crunch", "Hanging Leg Raises"));
        exerciseSelections.add(core);
    }

    public List<ExerciseSelection> getAllExerciseSelections()
    {
        return new ArrayList<>(exerciseSelections);
    }

    public ExerciseSelection getExercisesByMuscleGroup(String muscleGroup) {
        return exerciseSelections.stream()
                .filter(e -> e.getMuscleGroup().equalsIgnoreCase(muscleGroup))
                .findFirst()
                .orElse(null);
    }

    public List<String> getAllExercisesFlat() {
        return exerciseSelections.stream()
                .flatMap(e -> e.getExercises().stream())
                .toList();
    }
}
