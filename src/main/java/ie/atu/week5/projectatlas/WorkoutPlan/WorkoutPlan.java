package ie.atu.week5.projectatlas.WorkoutPlan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;
public class WorkoutPlan {
    private Long id;

    @NotBlank(message = "Workout Name Is Required")
    private String workoutName;

    @NotEmpty(message = "At Least One Exercise Must Be Selected")
    private List<WorkoutExercise> exercises;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public List<WorkoutExercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<WorkoutExercise> exercises) {
        this.exercises = exercises;
    }

    public static class WorkoutExercise {
        @NotBlank(message = "Exersice Name Is Required")
        private String exerciseName;

        @Positive(message = "Reps Must Be Greater Than Zero")
        private int reps;

        @Positive(message = "Sets Must Be Greater Than Zero")
        private int sets;

        public String getExerciseName() {
            return exerciseName;
        }

        public void setExerciseName(String exerciseName) {
            this.exerciseName = exerciseName;
        }

        public int getReps() {
            return reps;
        }

        public void setReps(int reps) {
            this.reps = reps;
        }

        public int getSets() {
            return sets;
        }

        public void setSets(int sets) {
            this.sets = sets;
        }
    }
}
