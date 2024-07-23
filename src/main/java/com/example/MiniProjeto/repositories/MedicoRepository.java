package com.example.MiniProjeto.repositories;

import com.example.MiniProjeto.entities.MedicoEntity;
import com.example.MiniProjeto.enums.EspecialidadeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {

    Page<MedicoEntity> findByNomeContainingIgnoreCaseAndDataNascimentoAndEspecialidade(
            String nome, LocalDate dataNascimento, EspecialidadeEnum especialidade, Pageable paginacao
    );

    Page<MedicoEntity> findByNomeContainingIgnoreCaseAndEspecialidade(
            String nome, EspecialidadeEnum especialidade, Pageable paginacao
    );

    Page<MedicoEntity> findByNomeContainingIgnoreCaseAndDataNascimento(
            String nome, LocalDate dataNascimento, Pageable paginacao
    );

    Page<MedicoEntity> findByNomeContainingIgnoreCase(
            String nome, Pageable paginacao
    );

    Boolean existsByCrm(String crm);
}
