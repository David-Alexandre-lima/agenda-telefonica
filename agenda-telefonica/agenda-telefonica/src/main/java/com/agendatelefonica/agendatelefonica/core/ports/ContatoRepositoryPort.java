package com.agendatelefonica.agendatelefonica.core.ports;

import com.agendatelefonica.agendatelefonica.core.domain.Contato;

import java.util.Collection;
import java.util.Optional;

public interface ContatoRepositoryPort {

    public Contato create(Contato contato);

    public Optional<Contato> findByTelefone(String telefone);

    Contato update(String nomeOriginal, Contato contato);

    Optional<Contato> findById(Long id);

    void deleteByNome(String nome);

    Optional<Contato> findByNome(String nome);

    Collection<Contato> listAll();
}
