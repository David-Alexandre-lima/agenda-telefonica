package com.agendatelefonica.agendatelefonica.adapter.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContatoDto {
    private Long id;
    private String telefone;
    private String nome;
}
