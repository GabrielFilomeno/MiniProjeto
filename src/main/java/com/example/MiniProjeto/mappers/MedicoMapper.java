package com.example.MiniProjeto.mappers;

import com.example.MiniProjeto.dtos.MedicoRequest;
import com.example.MiniProjeto.entities.MedicoEntity;

public class MedicoMapper {

    public static MedicoEntity map(MedicoRequest source){
        if (source == null) return null;

        MedicoEntity target = new MedicoEntity();

        target.setNome(source.getNome());
        target.setCrm(source.getCrm());
        target.setDataNascimento(source.getDataNascimento());
        target.setTelefone(source.getTelefone());
        target.setEspecialidade(source.getEspecialidade());

        return target;
    }
}
