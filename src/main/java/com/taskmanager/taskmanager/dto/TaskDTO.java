package com.taskmanager.taskmanager.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskDTO {

    @NotEmpty
    @Size(min=3)
    private String titel,beschrijving;
    @NotEmpty
    private LocalDateTime datum;
    @NotEmpty
    private Long id;

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

    public void setDatum(String datum) {
        this.datum = LocalDateTime.parse(datum);
    }

    public void setDatumNotString(LocalDateTime localDateTime){this.datum = localDateTime;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
