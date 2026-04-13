package ie.atu.project.atlasworkoutlog.WorkoutLogRepository;

import ie.atu.project.atlasworkoutlog.WorkoutLogModel.WorkoutLogModel;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutLogRepository extends JpaRepository<WorkoutLogModel, Long> {
}
