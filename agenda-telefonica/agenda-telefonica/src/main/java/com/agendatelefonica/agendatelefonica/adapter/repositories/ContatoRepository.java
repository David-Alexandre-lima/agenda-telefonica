package com.agendatelefonica.agendatelefonica.adapter.repositories;
import com.agendatelefonica.agendatelefonica.adapter.entities.ContatoEntity;
import com.agendatelefonica.agendatelefonica.core.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {
    Optional<ContatoEntity> findBytelefone(String telefone);
    Optional<ContatoEntity> findByNome(String nome);
    void deleteByNome(String nome);
}
