package com.hn.tasklist.repository;

import com.hn.tasklist.model.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Scope("singleton")
public final class TaskRepository {

    private static TaskRepository INSTANCE;

    private TaskRepository() {
    }

    public static TaskRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new TaskRepository();
        }

        return INSTANCE;
    }

    private final List<Task> taskList = new ArrayList<>();
    private Integer id = 0;

    public List<Task> findAll() {
        System.out.println("get all tasks");
        return taskList;
    }

    public Task save(String label) {
        Task task = new Task(this.id++, label);
        taskList.add(task);
        System.out.println("Add task: " + label);

        return task;
    }

    public List<Task> findCompletedTask(boolean status) {
        System.out.println("Find completed tasks");
        return taskList.stream().filter(task -> task.isComplete() == status).collect(Collectors.toList());
    }

    public Task findTaskId(Integer id) {
        System.out.println("Find task id: " + id);
        Optional<Task> task = taskList.stream().filter(t -> t.getId() == id).findFirst();
        return task.orElse(null);
    }

    public void updateStatus(Integer id) {
        System.out.println("Update status of task id: " + id);
        taskList.forEach(task -> {
            if(task.getId() == id) {
                task.setComplete(!task.isComplete());
            }
        });
    }
}
