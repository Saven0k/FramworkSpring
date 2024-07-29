package sem5.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sem5.homework.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
