package com.agendatelefonica.agendatelefonica.adapter.converters;

import com.agendatelefonica.agendatelefonica.adapter.dtos.ContatoDto;
import com.agendatelefonica.agendatelefonica.core.domain.Contato;
import org.springframework.stereotype.Component;

@Component
public class ContatoConverter {
    public Contato toDomain(ContatoDto contatoDto){
        return new Contato(contatoDto.getId(), contatoDto.getTelefone(), contatoDto.getNome());
    }

    public ContatoDto toDto(Contato contato){
        return new ContatoDto(contato.getId(), contato.getTelefone(), contato.getNome());
    }
}
