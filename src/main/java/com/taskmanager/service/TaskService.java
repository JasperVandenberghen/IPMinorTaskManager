package com.taskmanager.service;

import com.taskmanager.dto.SubTaskDTO;
import com.taskmanager.domain.Task;
import com.taskmanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {



    List<TaskDTO> getTasks();

    void addTask(TaskDTO task);

    Task getTask(Long id);

    TaskDTO updateTask(TaskDTO task);

    SubTaskDTO addSubTask(SubTaskDTO subTaskDTO);
}
