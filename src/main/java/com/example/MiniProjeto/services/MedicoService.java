package com.example.MiniProjeto.services;

import com.example.MiniProjeto.dtos.MedicoRequest;
import com.example.MiniProjeto.entities.MedicoEntity;
import com.example.MiniProjeto.repositories.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.MiniProjeto.mappers.MedicoMapper.map;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void cadastrarMedico(MedicoRequest medicoRequest) {
        //DOTO: tratar erro entity not found e duplicate key
        medicoRepository.save(map(medicoRequest));
    }

    public void atualizarMedico(Long medicoId, MedicoRequest medicoRequest) {
        //DOTO: tratar erros
        MedicoEntity medicoEntity = medicoRepository.findById(medicoId).orElseThrow(EntityNotFoundException::new);

        medicoEntity.setNome(medicoRequest.getNome());
        medicoEntity.setCrm(medicoRequest.getCrm());
        medicoEntity.setDataNascimento(medicoRequest.getDataNascimento());
        medicoEntity.setTelefone(medicoRequest.getTelefone());
        medicoEntity.setEspecialidade(medicoRequest.getEspecialidade());

        medicoRepository.save(medicoEntity);
    }
}
