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
    }

    public List<ExerciseSelection> getAllExerciseSelections()
    {
        return new ArrayList<>(exerciseSelections);
    }

    public ExerciseSelection getExercisesByMuscleGroup(String muscleGroup) {
        return exerciseSelections.stream()
                .filter(e -> e.getMuscleGroup().equals(muscleGroup))
                .findFirst()
                .orElse(null);
    }
}
