package com.taskmanager.taskmanager.dto;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class SubTaskDTO {

    @NotEmpty
    @Size(min=3)
    private String titel, beschrijving;
    @NotEmpty
    private Long id;

    private TaskDTO taskDTO;


    public TaskDTO getTaskDTO() {
        return taskDTO;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
