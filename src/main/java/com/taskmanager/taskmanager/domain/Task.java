package com.taskmanager.taskmanager.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {

    @NotEmpty
    @Size(min=3)
    private String titel,beschrijving;
    @NotEmpty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datum;

    @OneToMany
    private List<SubTask> subTasks = new ArrayList<>();;

    @Id
    @GeneratedValue
    private Long id;

    public Task(String titel, String beschrijving, LocalDateTime datum, Long id){
        setTitel(titel);
        setBeschrijving(beschrijving);
        setDatum(datum);
        setId(id);

    }

    public Task() {
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

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void addSubTask(SubTask subTask){
        this.subTasks.add(subTask);
    }
    public List<SubTask> getSubTasks() {
        return subTasks;
    }
}
