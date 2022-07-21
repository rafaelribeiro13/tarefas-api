package com.api.tarefas.dominio;

public class Tarefa {
    
    private int id;
    private String titulo;
    private boolean estaCompleta;
    
    public Tarefa(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        estaCompleta = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isEstaCompleta() {
        return estaCompleta;
    }

    public void setEstaCompleta(boolean estaCompleta) {
        this.estaCompleta = estaCompleta;
    }

    @Override
    public String toString() {
        return "Tarefa [estaCompleta=" + estaCompleta + ", id=" + id + ", titulo=" + titulo + "]";
    }
    
}
