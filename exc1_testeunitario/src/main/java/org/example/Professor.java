package org.example;

import com.google.gson.JsonArray;

public class Professor {
    private String nome;
    private String hora;
    private String periodo;
    private String sala;
    private String predio;

    public Professor(String nome, String hora, String periodo, String sala, String predio) {
        this.nome = nome;
        this.hora = hora;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
    }

    public String getNome() {
        return nome;
    }

    public String getHora() {
        return hora;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getSala() {
        return sala;
    }

    public String getPredio() {
        return predio;
    }
}
