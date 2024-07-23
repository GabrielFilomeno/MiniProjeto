package com.example.MiniProjeto.dtos;

import com.example.MiniProjeto.enums.EspecialidadeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class MedicoResponse {

    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private EspecialidadeEnum especialidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EspecialidadeEnum getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EspecialidadeEnum especialidade) {
        this.especialidade = especialidade;
    }
}
