package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.domain.Task;
import com.taskmanager.taskmanager.dto.SubTaskDTO;
import com.taskmanager.taskmanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {



    List<TaskDTO> getTasks();

    void addTask(TaskDTO task);

    Task getTask(Long id);

    void updateTask(TaskDTO task);

    void addSubTask(SubTaskDTO subTaskDTO);
}
