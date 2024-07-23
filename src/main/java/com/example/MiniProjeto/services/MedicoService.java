package com.example.MiniProjeto.services;

import com.example.MiniProjeto.dtos.MedicoGetRequest;
import com.example.MiniProjeto.dtos.MedicoRequest;
import com.example.MiniProjeto.dtos.MedicoResponse;
import com.example.MiniProjeto.entities.MedicoEntity;
import com.example.MiniProjeto.enums.EspecialidadeEnum;
import com.example.MiniProjeto.exceptions.exceptionsPersonalizadas.FiltrosException;
import com.example.MiniProjeto.repositories.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.example.MiniProjeto.mappers.MedicoMapper.map;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void cadastrarMedico(MedicoRequest medicoRequest) {
        if(medicoRepository.existsByCrm(medicoRequest.getCrm())) {
            throw new DuplicateKeyException("Já existe um médico cadastrado com esse crm: " + medicoRequest.getCrm());
        }
        medicoRepository.save(map(medicoRequest));
    }

    public void atualizarMedico(Long medicoId, MedicoRequest medicoRequest) {
        //DOTO: tratar erros
        MedicoEntity medicoEntity = medicoRepository.findById(medicoId).orElseThrow(()-> new EntityNotFoundException("Médico não encontrado com o ID: " + medicoId));

        medicoEntity.setNome(medicoRequest.getNome());
        medicoEntity.setCrm(medicoRequest.getCrm());
        medicoEntity.setDataNascimento(medicoRequest.getDataNascimento());
        medicoEntity.setTelefone(medicoRequest.getTelefone());
        medicoEntity.setEspecialidade(medicoRequest.getEspecialidade());

        medicoRepository.save(medicoEntity);
    }

    public Page<MedicoResponse> listarMedicos(MedicoGetRequest filtros, Pageable paginacao) {
        String filtroNome = filtros.getNome() != null ? filtros.getNome() : "";
        EspecialidadeEnum filtroEspecialidade = filtros.getEspecialidade();
        LocalDate filtroDataNascimento = filtros.getDataNascimento();

        Page<MedicoEntity> resultado;

        if (filtroDataNascimento != null && filtroEspecialidade != null){

            resultado = medicoRepository.findByNomeContainingIgnoreCaseAndDataNascimentoAndEspecialidade(
                    filtroNome, filtroDataNascimento, filtroEspecialidade, paginacao
            );
        } else if (filtroEspecialidade != null) {

            resultado = medicoRepository.findByNomeContainingIgnoreCaseAndEspecialidade(
                filtroNome, filtroEspecialidade, paginacao
        );
        } else if (filtroDataNascimento != null) {
            resultado = medicoRepository.findByNomeContainingIgnoreCaseAndDataNascimento(
               filtroNome, filtroDataNascimento, paginacao
            );
        } else {
            resultado = medicoRepository.findByNomeContainingIgnoreCase(
                    filtroNome, paginacao
            );
        }

        if (resultado.isEmpty()) {
            throw new FiltrosException("Nenhum médico encontrado com os filtros fornecidos.");
        }

        return map(resultado);
    }

    public MedicoResponse buscarMedico(Long medicoId) {
        MedicoEntity medicoEntity = medicoRepository.findById(medicoId).orElseThrow(()-> new EntityNotFoundException("Médico não encontrado com o ID: " + medicoId));
        return  map(medicoEntity);
    }

    public void deletarMedico(Long medicoId) {
        if(medicoRepository.existsById(medicoId)) {
            medicoRepository.deleteById(medicoId);
        } else {
            throw new EntityNotFoundException("Médico não encontrado com o ID: " + medicoId);
        }
    }
}
