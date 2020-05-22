package com.taskmanager;


import com.taskmanager.domain.Task;
import com.taskmanager.dto.SubTaskDTO;
import com.taskmanager.dto.TaskDTO;
import com.taskmanager.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;



    @Transactional
    @Test
    public void testGetTask(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1L);
        taskDTO.setTitel("boodschappen");
        taskDTO.setBeschrijving("collect & go");
        taskDTO.setDatumNotString(LocalDateTime.of(2020,5,22,11,0));
        taskService.addTask(taskDTO);

        Task task = taskService.getTask(taskDTO.getId());

        assertNotNull(task);
        assertEquals(task.getBeschrijving(), taskDTO.getBeschrijving());
        assertEquals(task.getTitel(), taskDTO.getTitel());
        assertEquals(task.getDatum(), taskDTO.getDatum());
        assertEquals(task.getId(), taskDTO.getId());
    }

    @Test
    public void testAddTask(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitel("boodschappen");
        taskDTO.setBeschrijving("collect & go");
        taskDTO.setDatumNotString(LocalDateTime.of(2020,5,22,11,0));
        taskService.addTask(taskDTO);

        assertNotNull(taskDTO);
        assertEquals("boodschappen", taskDTO.getTitel());
        assertEquals("collect & go", taskDTO.getBeschrijving());
        assertEquals(LocalDateTime.of(2020,5,22,11,0), taskDTO.getDatum());
    }
    @Transactional
    @Test
    public void testUpdateTask(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(2L);
        taskDTO.setTitel("boodschappen");
        taskDTO.setBeschrijving("collect & go");
        taskDTO.setDatumNotString(LocalDateTime.of(2020,5,22,11,0));
        taskService.addTask(taskDTO);


        TaskDTO taskDTO1 = new TaskDTO();
        taskDTO1.setId(taskDTO.getId());
        taskDTO1.setTitel("comisses");
        taskDTO1.setBeschrijving("colle en gaan");
        taskDTO1.setDatumNotString(LocalDateTime.of(2022,3,21,11,0));

        taskService.updateTask(taskDTO1);

        Task task = taskService.getTask(taskDTO.getId());

        assertEquals("comisses", task.getTitel());
        assertEquals("colle en gaan", task.getBeschrijving());
        assertEquals(LocalDateTime.of(2022,3,21,11,0), task.getDatum());
    }
    @Transactional
    @Test
    public void testAddSubTask(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1L);
        taskDTO.setTitel("boodschappen");
        taskDTO.setBeschrijving("collect & go");
        taskDTO.setDatumNotString(LocalDateTime.of(2020,5,22,11,0));
        taskService.addTask(taskDTO);


        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setBeschrijving("test");
        subTaskDTO.setTitel("test");
        subTaskDTO.setId(1L);

        taskService.addSubTask(subTaskDTO);

        assertNotEquals(0, taskService.getTask(taskDTO.getId()).getSubTasks().size());
    }

    @Test
    public void testGetTasks(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1L);
        taskDTO.setTitel("boodschappen");
        taskDTO.setBeschrijving("collect & go");
        taskDTO.setDatumNotString(LocalDateTime.of(2020,5,22,11,0));
        List<SubTaskDTO> subTaskDTOS = new ArrayList<>();
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setBeschrijving("test");
        subTaskDTO.setTitel("test");
        subTaskDTO.setId(1L);
        subTaskDTOS.add(subTaskDTO);
        taskDTO.setSubTasks(subTaskDTOS);
        taskService.addTask(taskDTO);


        List<TaskDTO> tasks = taskService.getTasks();

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(1, tasks.size());
        TaskDTO task = tasks.get(0);
        assertNotNull(task);
    }
}
