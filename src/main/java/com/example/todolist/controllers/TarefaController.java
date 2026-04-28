package com.example.todolist.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todolist.models.Tarefa;
import com.example.todolist.enums.TarefaStatus;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    private static List<Tarefa> tarefas = new ArrayList<>();
    private static Long proximoId = 1L;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tarefas", tarefas);
        return "tarefa-lista";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        return "tarefa-cadastro";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Tarefa> tarefa = tarefas.stream().filter(t -> t.getId().equals(id)).findFirst();
        if (tarefa.isPresent()) {
            model.addAttribute("tarefa", tarefa.get());
            return "tarefa-cadastro";
        }
        return "redirect:/tarefas";
    }

    @PostMapping("/salvar")
    public String salvar(Tarefa tarefa) {
        if (tarefa.getId() == null) {
            tarefa.setId(proximoId++);
            tarefa.setStatus(TarefaStatus.EM_ANDAMENTO);
            tarefas.add(tarefa);
        } else {
            // Atualizar tarefa existente
            for (int i = 0; i < tarefas.size(); i++) {
                if (tarefas.get(i).getId().equals(tarefa.getId())) {
                    // Mantém o status original ou permite alteração se vier do form
                    // Para simplificar, vamos assumir que o form pode enviar o status
                    tarefas.set(i, tarefa);
                    break;
                }
            }
        }
        return "redirect:/tarefas";
    }
}
