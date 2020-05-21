package com.taskmanager.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class SubTask {

    @NotEmpty
    @Size(min=1)
    private String titel, beschrijving;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Task task;

    public SubTask(Task task, String title, String description){
        this.setTask(task);
        this.setTitel(title);
        this.setBeschrijving(description);
    }

    public SubTask(String title, String description){
        super();
    }

    public SubTask() {
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
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
