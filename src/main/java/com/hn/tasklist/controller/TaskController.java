package com.hn.tasklist.controller;

import com.hn.tasklist.model.Task;
import com.hn.tasklist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Task Controller
 *
 * @author fsaldanha
 */
@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository = TaskRepository.getInstance();

    /**
     * Get all tasks.
     *
     * @return the list of tasks
     */
    @GetMapping("/allTasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Return the incomplete tasks.
     *
     * @return the list with todo tasks
     */
    @GetMapping("/taskTodo")
    public List<Task> getIncompleteTasks(){
        return taskRepository.findCompletedTask(false);
    }

    /**
     * Return the task id.
     *
     * @param id the id of task
     * @return
     */
    @GetMapping("/taskId/{id}")
    public Task getTaskId(@PathVariable(value = "id") Integer id){
        return taskRepository.findTaskId(id);
    }

    /**
     * Add a new task.
     *
     * @param label the description of task.
     *
     * @return the task created
     */
    @GetMapping(value = "/addTask/{label}")
    public Task addTask(@PathVariable(value = "label") String label) {
        return taskRepository.save(label);
    }

    /**
     * Change the status of task.
     *
     * @param id
     * @return
     */
    @GetMapping("/updateTaskStatus/{id}")
    public Task updateTaskStatus(@PathVariable(value = "id") Integer id) {
        taskRepository.updateStatus(id);

        return taskRepository.findTaskId(id);
    }
}
