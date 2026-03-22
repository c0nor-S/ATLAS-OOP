package ie.atu.week5.projectatlas.WorkoutPlanController;

import ie.atu.week5.projectatlas.WorkoutPlanService.WorkoutPlanService;
import ie.atu.week5.projectatlas.WorkoutPlan.WorkoutPlan;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workoutPlans")
public class WorkoutPlanController {

    private final WorkoutPlanService workoutPlanService;

    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }

    @PostMapping
    public ResponseEntity<WorkoutPlan> createWorkoutPlan(@Valid @RequestBody WorkoutPlan workoutPlan) {
        try {
            WorkoutPlan created = workoutPlanService.createWorkoutPlan(workoutPlan);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<WorkoutPlan>> getAllWorkoutPlans() {
        return ResponseEntity.ok(workoutPlanService.getAllWorkoutPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutPlan> getWorkoutPlanById(@PathVariable int id) {
        WorkoutPlan workoutPlan = workoutPlanService.getWorkoutPlanById(id);
        if (workoutPlan == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(workoutPlan);
    }

}

