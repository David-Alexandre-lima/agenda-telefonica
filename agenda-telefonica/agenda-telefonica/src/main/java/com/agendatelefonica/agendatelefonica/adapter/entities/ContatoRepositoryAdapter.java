package com.agendatelefonica.agendatelefonica.adapter.entities;

import com.agendatelefonica.agendatelefonica.adapter.repositories.ContatoRepository;
import com.agendatelefonica.agendatelefonica.core.domain.Contato;
import com.agendatelefonica.agendatelefonica.core.exceptions.BusinessException;
import com.agendatelefonica.agendatelefonica.core.ports.ContatoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class  ContatoRepositoryAdapter implements ContatoRepositoryPort {

    private final ContatoRepository contatoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Contato create(Contato contato) {
       ContatoEntity entity = modelMapper.map(contato, ContatoEntity.class);
       ContatoEntity novoContato = contatoRepository.save(entity);
       return modelMapper.map(novoContato, Contato.class);
    }

    @Override
    public Optional<Contato> findByTelefone(String telefone) {
      return contatoRepository
                .findBytelefone(telefone)
                .map(contatoEntity
                        -> modelMapper.map(contatoEntity,Contato.class));
    }

    @Override
    public Contato update(String nomeOriginal, Contato contato) {
        ContatoEntity entity = contatoRepository.findByNome(nomeOriginal)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        entity.setNome(contato.getNome());
        entity.setTelefone(contato.getTelefone());
        return modelMapper.map(contatoRepository.save(entity), Contato.class);
    }

    @Override
    public Optional<Contato> findById(Long id) {
        return contatoRepository.findById(id)
                .map(entity -> modelMapper.map(entity, Contato.class));
    }

    @Override
    public void deleteByNome(String nome) {
        ContatoEntity entity = contatoRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        contatoRepository.deleteById(entity.getId());
    }

    @Override
    public Optional<Contato> findByNome(String nome) {
        return contatoRepository.findByNome(nome)
                .map(contatoEntity
                        -> modelMapper.map(contatoEntity, Contato.class));
    }

    @Override
    public Collection<Contato> listAll() {
        return contatoRepository.findAll().stream()
                .map(contatoEntity -> modelMapper
                .map(contatoEntity, Contato.class))
                .toList();
    }

}
