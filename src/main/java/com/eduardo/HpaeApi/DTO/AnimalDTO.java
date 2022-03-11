package com.eduardo.HpaeApi.DTO;

import com.eduardo.HpaeApi.entities.Animal;
import com.eduardo.HpaeApi.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AnimalDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    private String nomeAnimal;

    private String raca;

    private Long dono;

    private Double valor;

    public AnimalDTO(){}

    public AnimalDTO(Animal obj) {
        this.id = obj.getId();
        this.dataInicio = obj.getDataInicio();
        this.dataFim = obj.getDataFim();
        this.nomeAnimal = obj.getNomeAnimal();
        this.raca = obj.getRaca();
        this.dono = obj.getDono().getId();
        this.valor = obj.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Long getDono() {
        return dono;
    }

    public void setDono(Long dono) {
        this.dono = dono;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
