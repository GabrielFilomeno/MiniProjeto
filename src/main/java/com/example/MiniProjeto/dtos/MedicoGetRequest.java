package com.example.MiniProjeto.dtos;

import com.example.MiniProjeto.enums.EspecialidadeEnum;

import java.time.LocalDate;

public class MedicoGetRequest {
    private String nome;
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
