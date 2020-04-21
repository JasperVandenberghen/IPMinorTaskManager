package com.taskmanager.taskmanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private LocalDateTime datum;

    @OneToMany
    private List<SubTask> subTasks;

    @Id
    @GeneratedValue
    private int id;

    public Task(String titel, String beschrijving, LocalDateTime datum, int id){
        setTitel(titel);
        setBeschrijving(beschrijving);
        setDatum(datum);
        setId(id);
        subTasks = new ArrayList<>();
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void addSubTask(SubTask subTask){
        this.subTasks.add(subTask);
    }
    public List<SubTask> getSubTasks() {
        return subTasks;
    }
}
