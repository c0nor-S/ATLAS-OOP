package ie.atu.week5.projectatlas.ExerciseSelectionService;

import ie.atu.week5.projectatlas.ExerciseSelection.ExerciseSelection;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseSelectionService {
    private final List<ExerciseSelection> exerciseSelections = new ArrayList<>();
    private long nextMuscleGroupID = 1;
    public ExerciseSelection addExerciseSelection(ExerciseSelection exerciseSelection)
    {
        exerciseSelection.setMuscleGroupID(nextMuscleGroupID++);
        exerciseSelections.add(exerciseSelection);
        return exerciseSelection;
    }
    public List<ExerciseSelection> getAllExerciseSelections()
    {
        return exerciseSelections;
    }
}
