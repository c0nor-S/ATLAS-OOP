package ie.atu.sem2.project_atlas_history_log.projectatlas_achievementlog.WorkoutAchievementModel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class WorkoutAchievementModel {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull(message = "Wor");
}
