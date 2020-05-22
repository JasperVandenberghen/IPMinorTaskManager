package com.taskmanager.service;

import com.taskmanager.domain.SubTask;
import com.taskmanager.dto.SubTaskDTO;
import com.taskmanager.repository.SubTaskRepoJPA;
import com.taskmanager.repository.TaskRepoJPA;
import com.taskmanager.domain.Task;
import com.taskmanager.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepoJPA taskRepository;


    @Autowired
    public TaskServiceImp(TaskRepoJPA taskRepository){
        this.taskRepository = taskRepository;

    }

    @Override
    public List<TaskDTO> getTasks() {

        return taskRepository.findAll().stream().map(h -> {
            TaskDTO dto = new TaskDTO();
            dto.setBeschrijving(h.getBeschrijving());
            dto.setDatumNotString(h.getDatum());
            dto.setTitel(h.getTitel());
            dto.setId(h.getId());
            dto.setSubTasks(h.getSubTasksDTO());
            return dto;
        }).collect(Collectors.toList());

    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setBeschrijving(taskDTO.getBeschrijving());
        task.setTitel(taskDTO.getTitel());
        task.setDatum(taskDTO.getDatum());
        taskRepository.save(task);
    }

    @Override
    public Task getTask(Long id){
        return taskRepository.getOne(id);
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO) {
        Long id = taskDTO.getId();
        Task task = this.taskRepository.findById(id).get();
        task.setBeschrijving(taskDTO.getBeschrijving());
        task.setTitel(taskDTO.getTitel());
        task.setDatum(taskDTO.getDatum());
        taskRepository.save(task);
        TaskDTO taskDTO1 = new TaskDTO();
        taskDTO1.setBeschrijving(task.getBeschrijving());
        taskDTO1.setTitel(task.getTitel());
        taskDTO1.setDatumNotString(task.getDatum());
        return taskDTO1;


    }

    @Override
    public SubTaskDTO addSubTask(SubTaskDTO subTaskDTO) {
        Long id = subTaskDTO.getId();

        SubTask subTask = new SubTask();
        subTask.setBeschrijving(subTaskDTO.getBeschrijving());
        subTask.setTitel(subTaskDTO.getTitel());


        Task task1 = this.taskRepository.findById(id).get();
        subTask.setTask(task1);

        task1.addSubTask(subTask);
        taskRepository.save(task1);

        SubTaskDTO subTaskDTO1 = new SubTaskDTO();
        subTaskDTO1.setBeschrijving(subTask.getBeschrijving());
        subTaskDTO1.setTitel(subTask.getTitel());

        return subTaskDTO;

    }

}
