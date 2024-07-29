package sem5.homework.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sem5.homework.model.Task;
import sem5.homework.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    public final TaskService taskServer;

    @GetMapping()
    public List<Task> getAllTasks(){return taskServer.getAllTasks();}
}
