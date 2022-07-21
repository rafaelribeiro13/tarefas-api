package com.api.tarefas.infraestrutura;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.api.tarefas.dominio.Tarefa;

@Repository
public class RepositorioTarefas {
    
    private List<Tarefa> tarefas = List.of(
        new Tarefa(20, "Estudar Spring"),
        new Tarefa(78, "Estudar API"),
        new Tarefa(178784, "Estudar Java")
    );

    public List<Tarefa> adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        return tarefas;
    }

    public void excluirTarefa(int id) {
        Tarefa tarefa = obterTarefaPorId(id);
        if (tarefa != null) {
            tarefas.remove(tarefa);
        }
    }

    public Tarefa obterTarefaPorId(int id) {
        if (tarefas.size() > 0) {
            return tarefas.stream()
                .filter(x -> x.getId() == id)
                .collect(Collectors.toList())
                .get(0);
        }

        return null;
    }

    public List<Tarefa> getTarefas() {
        return Collections.unmodifiableList(tarefas);
    }

}
