package com.agendatelefonica.agendatelefonica.core.services;

import com.agendatelefonica.agendatelefonica.core.domain.Contato;
import com.agendatelefonica.agendatelefonica.core.exceptions.BusinessException;
import com.agendatelefonica.agendatelefonica.core.ports.ContatoRepositoryPort;
import com.agendatelefonica.agendatelefonica.core.ports.ContatoServicePort;

import java.util.Collection;

public class ContatoService implements ContatoServicePort {

    private final ContatoRepositoryPort contatoRepositoryPort;

    public ContatoService(ContatoRepositoryPort contatoRepositoryPort) {
        this.contatoRepositoryPort = contatoRepositoryPort;
    }
    //Buscar contato por telefone
    @Override
    public Contato createContato(Contato contato) {
       contatoRepositoryPort.findByTelefone(contato.getTelefone())
               .ifPresent( C ->{
                   throw new BusinessException("Contato já existe");
               });
        return contatoRepositoryPort.create(contato);
    }

    @Override
    public Contato findById(Long id) {
        return contatoRepositoryPort.findById(id)
                .orElseThrow(() -> new BusinessException("Contato não encontrado: " + id));
    }

    //Buscar contato por nome
    @Override
    public Contato findByNome(String nome) {
        return contatoRepositoryPort.findByNome(nome)
                .orElseThrow(() -> new BusinessException("Contato não encontrado"));
    }

    @Override
    public Contato update(String nome, Contato contato) {
        contatoRepositoryPort.findByNome(nome)
                .orElseThrow(() -> new BusinessException("Contato não encontrado: " + nome));
        return contatoRepositoryPort.update(nome, contato);
    }


    @Override
    public void delete(String nome) {
        Contato existente = contatoRepositoryPort.findByNome(nome)
                .orElseThrow(() -> new BusinessException("Contato não encontrado: " + nome));
        contatoRepositoryPort.deleteByNome(existente.getNome());
    }

    //Listar contatos
    @Override
    public Collection<Contato> listAll() {
        return contatoRepositoryPort.listAll();
    }

}
