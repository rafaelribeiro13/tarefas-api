package com.api.tarefas.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.tarefas.dominio.Tarefa;
import com.api.tarefas.repositories.RepositorioTarefas;

@RestController
public class TarefasController {
    
    private RepositorioTarefas repositorioTarefas;

    public TarefasController(RepositorioTarefas repositorioTarefas) {
    	this.repositorioTarefas = repositorioTarefas;
    }

    @GetMapping("/tarefas/{id}")
    public Tarefa obterTarefaPeloId(@PathVariable int id) {
        return repositorioTarefas.obterTarefaPorId(id);
    }

    @GetMapping("/tarefas")
    public List<Tarefa> obterTarefas() {
        return repositorioTarefas.getTarefas();
    }

    @PostMapping("/tarefas")
    public List<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        return repositorioTarefas.adicionarTarefa(tarefa);
    }
    
    @DeleteMapping("/tarefas/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void excluirTarefa(@PathVariable int id) {
        repositorioTarefas.excluirTarefa(id);
    }

    @PatchMapping("/tarefas/{id}")
    public Tarefa completarTarefa(@PathVariable int id, @RequestBody boolean estaCompleta) {
        Tarefa tarefa = repositorioTarefas.obterTarefaPorId(id);
        tarefa.setEstaCompleta(estaCompleta);

        return tarefa;
    }

}
