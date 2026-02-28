package ie.atu.week5.projectatlas.ExerciseSelectionController;

import ie.atu.week5.projectatlas.ExerciseSelection.ExerciseSelection;
import ie.atu.week5.projectatlas.ExerciseSelectionService.ExerciseSelectionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exerciseSelection")
public class ExerciseSelectionController {

    private final ExerciseSelectionService exerciseSelectionService;

    public ExerciseSelectionController(ExerciseSelectionService exerciseSelectionService) {
        this.exerciseSelectionService = exerciseSelectionService;
    }
    @GetMapping("/allExercises")
    public ResponseEntity<ExerciseSelection> getAllExerciseSelections(@RequestParam String muscleGroup) {
        ExerciseSelection result = exerciseSelectionService.getExercisesByMuscleGroup(muscleGroup);

        if (result != null) {
            return ResponseEntity.ok(result);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
