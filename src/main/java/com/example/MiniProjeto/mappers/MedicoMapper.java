package com.example.MiniProjeto.mappers;

import com.example.MiniProjeto.dtos.MedicoRequest;
import com.example.MiniProjeto.dtos.MedicoResponse;
import com.example.MiniProjeto.entities.MedicoEntity;
import org.springframework.data.domain.Page;

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

    public static MedicoResponse map(MedicoEntity source) {

        MedicoResponse target = new MedicoResponse();

        target.setNome(source.getNome());
        target.setDataNascimento(source.getDataNascimento());
        target.setEspecialidade(source.getEspecialidade());

        return target;
    }

    public static Page<MedicoResponse> map(Page<MedicoEntity> source) {
        return source.map(MedicoMapper::map);
    }
}
