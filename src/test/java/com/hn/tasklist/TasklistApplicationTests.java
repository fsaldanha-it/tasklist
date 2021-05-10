package com.hn.tasklist;

import com.hn.tasklist.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class TasklistApplicationTests {

    final TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    int randomServerPort;

    private String getRootUrl() {
        return "http://localhost:" + randomServerPort + "/api/v1/";
    }

    private void contextLoads() {
        addTask("Task 1");
        addTask("Task 2");
        addTask("Task 3");
        addTask("Task 4");
    }

    @Test
    public void testGetAllTasks() {
        contextLoads();
        ResponseEntity<String> response = restTemplate.getForEntity(getRootUrl() + "/allTasks", String.class);
        Assert.notNull(response.getBody(), "Tasks returned");
    }

    @Test
    public void testGetTaskTodo() {
        ResponseEntity<List<Task>> responseEntity =
                restTemplate.exchange(
                        getRootUrl() + "/taskTodo",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Task>>() {}
                );
        List<Task> tasks = responseEntity.getBody();
        assert tasks != null;
        System.out.println("Total tasks: " + tasks.size());
        Assert.isTrue(tasks.size() > 0, "There are" + tasks.size() + " pending tasks");
    }

    @Test
    public void testGetTaskById() {
        Task task = restTemplate.getForObject(getRootUrl() + "/taskId/1", Task.class);
        System.out.println(task.getLabel());
        Assert.isTrue("Task 1".equals(task.getLabel()), "Correct tast returned");
    }

    @Test
    public void testAddTask() {
        Task task = restTemplate.getForObject(getRootUrl() + "/addTask/Task 5", Task.class);
        System.out.println(task.getId());
    }

    @Test
    public void testUpdateTask() {
        Task task = restTemplate.getForObject(getRootUrl() + "/updateTaskStatus/2", Task.class);
        System.out.println(task.getId());
    }

    private void addTask(String label) {
        restTemplate.getForObject(getRootUrl() + "/addTask/" + label, Task.class);
    }

}
