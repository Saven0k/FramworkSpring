package sem5.homework.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem5.homework.model.Task;
import sem5.homework.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){return taskRepository.findAll();}

    public Optional<Task> getTaskById(Long id){return taskRepository.findById(id);}

    public Task createTask(Task task) {return taskRepository.save(task);}

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task changeStatus(Task.Status status, Long id){
        Task findTask = taskRepository.findById(id).get();
        if (findTask != null) {
            findTask.setStatus(status);
            return findTask;
        } else {
            throw new IllegalArgumentException("Task not find with id: " + id);
        }
    }

    public Task updateTask(Task UpdatedTask, Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(UpdatedTask.getStatus());
            task.setDiscription(UpdatedTask.getDiscription());
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id:" + id);
        }
    }
}
