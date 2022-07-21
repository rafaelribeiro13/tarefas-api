package com.api.tarefas.application;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.tarefas.dominio.Tarefa;
import com.api.tarefas.infraestrutura.RepositorioTarefas;

// @RequestMapping("/tarefas")
@RestController
public class TarefasController {
    
    private RepositorioTarefas repositorioTarefas;

    public TarefasController() {
        repositorioTarefas = new RepositorioTarefas();
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
    
    // delete
    @DeleteMapping("/tarefas/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void excluirTarefa(@PathVariable int id) {
        repositorioTarefas.excluirTarefa(id);
    }

    // update


}
