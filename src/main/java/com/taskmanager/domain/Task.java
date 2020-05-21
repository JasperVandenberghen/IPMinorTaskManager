package com.taskmanager.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {

    @NotEmpty
    @Size(min=1)
    private String titel,beschrijving;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datum;

    @OneToMany(mappedBy="task")
    private List<SubTask> subTasks = new ArrayList<>();;

    @Id
    @GeneratedValue
    private Long id;

    public Task(String titel, String beschrijving, LocalDateTime datum){
        setTitel(titel);
        setBeschrijving(beschrijving);
        setDatum(datum);

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
