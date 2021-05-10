package com.hn.tasklist;

import com.hn.tasklist.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
class TasklistApplicationTests {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    int randomServerPort;

    private String getRootUrl() {
        return "http://localhost:" + randomServerPort;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetAllTasks() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/allTasks",
                HttpMethod.GET, entity, String.class);
        //Verify request succeed
    }

    @Test
    public void testGetTaskTodo() {
        List<Task> tasks = (List<Task>) restTemplate.getForObject(getRootUrl() + "/taskTodo", Task.class);
        System.out.println(tasks);
        Assert.isNull(tasks, "Is not null");
    }

    @Test
    public void testGetTaskById() {
        Task task = restTemplate.getForObject(getRootUrl() + "/taskId/1", Task.class);
        System.out.println(task.getId());
        Assert.isNull(task, "Is not null");
    }

    @Test
    public void testAddTask() {
        Task task = restTemplate.getForObject(getRootUrl() + "/addTask/test", Task.class);
        System.out.println(task.getId());
        Assert.isNull(task, "Is not null");
    }
}
