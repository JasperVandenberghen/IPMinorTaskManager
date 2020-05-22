package com.taskmanager.controller;

import com.taskmanager.domain.Task;
import com.taskmanager.dto.SubTaskDTO;
import com.taskmanager.dto.TaskDTO;
import com.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/{id}")
    public String getTask(Model model, @PathVariable("id") Long id){

        model.addAttribute("task", taskService.getTask(id) );
        return "task";
    }

    @GetMapping("/new")
    public String getNew(Model model){
        model.addAttribute("taskDTO", new TaskDTO());
        return "new";
    }

    @PostMapping("/new")
    public String postNew(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "new";
        }
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String getUpdate(Model model, @PathVariable("id") Long id){
        model.addAttribute("task", taskService.getTask(id) );
        model.addAttribute("subTask", new SubTaskDTO());
        model.addAttribute("id", id );
        return "edit";
    }

    @PostMapping("/edit")
    public String postUpdate(@ModelAttribute TaskDTO taskDTO){

        taskService.updateTask(taskDTO);
        return "redirect:/tasks/"+taskDTO.getId();
    }




    @GetMapping("/{id}/sub/create")
    public String getCreateSubTask(Model model, @PathVariable("id") Long id){
        model.addAttribute("id", id );
        return "createSubTask";
    }

    @PostMapping("/sub/create")
    public String postNew(@ModelAttribute SubTaskDTO subTaskDTO, Model model){

        taskService.addSubTask(subTaskDTO);
        model.addAttribute("task", taskService.getTask(subTaskDTO.getId()));
        return "redirect:/tasks/"+subTaskDTO.getId();
    }




}
