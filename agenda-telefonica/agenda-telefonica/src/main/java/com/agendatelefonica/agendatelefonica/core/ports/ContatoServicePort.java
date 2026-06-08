package com.agendatelefonica.agendatelefonica.core.ports;

import com.agendatelefonica.agendatelefonica.core.domain.Contato;

import java.util.Collection;

public interface ContatoServicePort {
    Contato createContato(Contato contato);

    Contato findById(Long id);

    Contato findByNome(String nome);

    Contato update(String nome, Contato contato);

    void delete(String nome);

    Collection<Contato>listAll();
}
