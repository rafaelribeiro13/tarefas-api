package com.api.tarefas.API.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tarefas.dominio.Tarefa;
import com.api.tarefas.infraestrutura.RepositorioTarefas;

@RequestMapping("/tarefas")
@RestController
public class TarefasController {
    
    private RepositorioTarefas repositorioTarefas;

    public TarefasController() {
        repositorioTarefas = new RepositorioTarefas();
    }

    @GetMapping("/")
    public List<Tarefa> obterTarefas() {
        return repositorioTarefas.getTarefas();
    }

    @PostMapping("/")
    public List<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        return repositorioTarefas.adicionarTarefa(tarefa);
    }
    
}
