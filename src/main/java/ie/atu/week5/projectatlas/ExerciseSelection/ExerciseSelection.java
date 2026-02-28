package ie.atu.week5.projectatlas.ExerciseSelection;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class ExerciseSelection {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long muscleGroupID;

    @NotBlank(message = "Muscle Group Is Required")
    private String muscleGroup;

    private List<String> exercises;

    public Long getMuscleGroupID() {
        return muscleGroupID;
    }

    public void setMuscleGroupID(Long muscleGroupID) {
        this.muscleGroupID = muscleGroupID;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public List<String> getExercises() {
        return exercises;
    }

    public void setExercises(List<String> exercises) {
        this.exercises = exercises;
    }
}
