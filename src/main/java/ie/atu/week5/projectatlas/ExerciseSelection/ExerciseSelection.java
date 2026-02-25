package ie.atu.week5.projectatlas.ExerciseSelection;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseSelection {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long muscleGroupID;

    public void setMuscleGroupID(Long muscleGroupID) {
        this.muscleGroupID = muscleGroupID;
    }

    @NotBlank(message = "Muscle Group Is Required")
    private String muscleGroup;
}
