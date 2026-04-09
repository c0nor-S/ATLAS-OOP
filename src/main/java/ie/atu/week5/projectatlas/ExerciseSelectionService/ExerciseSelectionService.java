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
        chest.setExercises(List.of(
                new String("Flat Bench Press | " + 2 + " Minutes"),
                new String("Incline Bench Press | " + 2 + " Minutes"),
                new String("Chest Fly | " + 2 + " Minutes"),
                new String("Push Up | " + 2 + " Minutes")
                ));
        exerciseSelections.add(chest);

        ExerciseSelection back = new ExerciseSelection();
        back.setMuscleGroupID(nextMuscleGroupID++);
        back.setMuscleGroup("Back");
        back.setExercises(List.of(
                new String("Pull Up | " + 2 + " Minutes"),
                new String("Lat Pulldown | " + 2 + " Minutes"),
                new String ("Deadlift | " + 2 + " Minutes"),
                new String("T-Bar Row | " + 2 + " Minutes")
        ));
        exerciseSelections.add(back);

        ExerciseSelection arms = new ExerciseSelection();
        arms.setMuscleGroupID(nextMuscleGroupID++);
        arms.setMuscleGroup("Arms");
        arms.setExercises(List.of(
                new String("Barbell Curl | " + 2 + " Minutes"),
                new String("Dumbbell Hammer Curl | " + 2 + " Minutes"),
                new String("Preacher Curl | " + 2 + " Minutes"),
                new String("Machine Tricep Pushdown | " + 2 + " Minutes"),
                new String("Overhead Dumbbell Tricep Extension | " + 2 + " Minutes"),
                new String("Tricep Dips | " + 2 + " Minutes")
        ));
        exerciseSelections.add(arms);

        ExerciseSelection shoulders = new ExerciseSelection();
        shoulders.setMuscleGroupID(nextMuscleGroupID++);
        shoulders.setMuscleGroup("Shoulders");
        shoulders.setExercises(List.of(
                new String("Overhead Press | " + 2 + " Minutes"),
                new String("Lateral Raises | " + 2 + " Minutes")
        ));
        exerciseSelections.add(shoulders);

        ExerciseSelection legs = new ExerciseSelection();
        legs.setMuscleGroupID(nextMuscleGroupID++);
        legs.setMuscleGroup("Legs");
        legs.setExercises(List.of(
                new String("Barbell Squat | " + 2 + " Minutes"),
                new String("Hack Squat | " + 2 + " Minutes"),
                new String("Leg Press | " + 2 + " Minutes"),
                new String("Leg Curls | " + 2 + " Minutes"),
                new String("Leg Extensions | " + 2 + " Minutes"),
                new String("Calf Raises | " + 2 + " Minutes")
        ));
        exerciseSelections.add(legs);

        ExerciseSelection core = new ExerciseSelection();
        core.setMuscleGroupID(nextMuscleGroupID++);
        core.setMuscleGroup("Core");
        core.setExercises(List.of(
                new String("Machine Crunch | " + 2 + " Minutes"),
                new String("Cable Crunch | " + 2 + " Minutes"),
                new String("Hanging Leg Raises | " + 2 + " Minutes")
        ));
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
