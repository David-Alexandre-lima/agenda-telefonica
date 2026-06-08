package com.agendatelefonica.agendatelefonica.adapter.controller;
import com.agendatelefonica.agendatelefonica.adapter.converters.ContatoConverter;
import com.agendatelefonica.agendatelefonica.adapter.dtos.ContatoDto;
import com.agendatelefonica.agendatelefonica.core.domain.Contato;
import com.agendatelefonica.agendatelefonica.core.ports.ContatoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contatos")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoServicePort contatoServicePort;
    private final ContatoConverter contatoConverter;

    @GetMapping
    public List<ContatoDto> listAll(){
        return contatoServicePort.listAll().stream()
        .map(contatoConverter::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoDto create(@RequestBody ContatoDto contatoDto) {
        return contatoConverter.
                toDto(contatoServicePort.createContato(contatoConverter.toDomain(contatoDto)));
    }

    @GetMapping("/{nome}")
    public ContatoDto ObterPorNome(@PathVariable String nome){
        return contatoConverter.toDto(contatoServicePort.findByNome(nome));
    }

    @PutMapping("/{nome}")
    public ContatoDto update(@PathVariable String nome,
                             @RequestBody ContatoDto contatoDto) {
        Contato contato = contatoConverter.toDomain(contatoDto);
        return contatoConverter
                .toDto(contatoServicePort.update(nome, contato));
    }


    @GetMapping("/id/{id}")
    public ContatoDto findById(@PathVariable Long id) {
        return contatoConverter.toDto(contatoServicePort.findById(id));
    }

    @DeleteMapping("/{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String nome) {
        contatoServicePort.delete(nome);
    }

}
