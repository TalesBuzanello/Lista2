package com.example.todolist.models;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.example.todolist.enums.TarefaStatus;

public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    private TarefaStatus status;

    public Tarefa() {
    }

    public Tarefa(Long id, String titulo, String descricao, LocalDate data, TarefaStatus status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public TarefaStatus getStatus() {
        return status;
    }

    public void setStatus(TarefaStatus status) {
        this.status = status;
    }
}
