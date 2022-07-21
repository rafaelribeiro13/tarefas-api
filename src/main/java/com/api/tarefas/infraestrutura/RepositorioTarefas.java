package com.api.tarefas.infraestrutura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.tarefas.dominio.Tarefa;

@Repository
public class RepositorioTarefas {
    
    private List<Tarefa> tarefas = new ArrayList<>();

    public List<Tarefa> adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        return tarefas;
    }

    public List<Tarefa> getTarefas() {
        return Collections.unmodifiableList(tarefas);
    }

}
