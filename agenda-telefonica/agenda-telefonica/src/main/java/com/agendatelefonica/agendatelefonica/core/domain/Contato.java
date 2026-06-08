package com.agendatelefonica.agendatelefonica.core.domain;

public class Contato {
   private String telefone;
   private String nome;
   private Long id;

    public Contato() {
    }

    public Contato(Long id, String telefone, String nome) {
        this.telefone = telefone;
        this.nome = nome;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

