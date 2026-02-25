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
    @PostMapping("/addExercise")
    public ResponseEntity<ExerciseSelection> addExercise(@Valid @RequestBody ExerciseSelection exerciseSelection) {
        ExerciseSelection saved = exerciseSelectionService.addExerciseSelection(exerciseSelection);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping("/allExercises")
    public ResponseEntity<List<ExerciseSelection>> getAllExercises() {
        return ResponseEntity.ok(exerciseSelectionService.getAllExerciseSelections());
    }
}
