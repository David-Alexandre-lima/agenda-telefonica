package com.agendatelefonica.agendatelefonica.infra;

import com.agendatelefonica.agendatelefonica.core.ports.ContatoRepositoryPort;
import com.agendatelefonica.agendatelefonica.core.ports.ContatoServicePort;
import com.agendatelefonica.agendatelefonica.core.services.ContatoService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ContatoServicePort contatoServicePortImpl(ContatoRepositoryPort contatoRepositoryPort){
        return new ContatoService(contatoRepositoryPort);
    }
}
