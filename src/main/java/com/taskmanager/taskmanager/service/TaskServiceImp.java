package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.domain.SubTask;
import com.taskmanager.taskmanager.domain.Task;
import com.taskmanager.taskmanager.dto.SubTaskDTO;
import com.taskmanager.taskmanager.dto.TaskDTO;
import com.taskmanager.taskmanager.repository.TaskRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepoJPA taskRepository;
  //  private int taskId = 0;

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
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
     //   taskId++;
        Task task = new Task();
        task.setBeschrijving(taskDTO.getBeschrijving());
        task.setTitel(taskDTO.getTitel());
        task.setDatum(taskDTO.getDatum());
       // task.setId((long) taskId);
        taskRepository.save(task);
    }

    @Override
    public Task getTask(Long id){
        return taskRepository.getOne(id);
    }

    @Override
    public void updateTask(TaskDTO taskDTO) {

        /*taskRepository.updateTask(new Task(
                taskDTO.getTitel() ,
                taskDTO.getBeschrijving() ,
                taskDTO.getDatum(),
                taskDTO.getId() )
        );*/

    }

    @Override
    public void addSubTask(SubTaskDTO subTaskDTO) {
        /*taskRepository.addSubTask(new SubTask(
                subTaskDTO.getTitel(),
                subTaskDTO.getBeschrijving()
        ),
                subTaskDTO.getId()
        );*/
    }

}
