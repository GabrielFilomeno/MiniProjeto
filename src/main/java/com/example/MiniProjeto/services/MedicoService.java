package com.example.MiniProjeto.services;

import com.example.MiniProjeto.dtos.MedicoRequest;
import com.example.MiniProjeto.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

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
}
