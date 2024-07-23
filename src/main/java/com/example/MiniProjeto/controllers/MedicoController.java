package com.example.MiniProjeto.controllers;

import com.example.MiniProjeto.dtos.MedicoGetRequest;
import com.example.MiniProjeto.dtos.MedicoRequest;
import com.example.MiniProjeto.dtos.MedicoResponse;
import com.example.MiniProjeto.services.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        this.medicoService = medicoService;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarMedico(@RequestBody MedicoRequest medicoRequest){
        medicoService.cadastrarMedico(medicoRequest);
    }

    @PutMapping("/atualizar/{medicoId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizarMedico(@PathVariable Long medicoId, @RequestBody MedicoRequest medicoRequest){
        medicoService.atualizarMedico(medicoId, medicoRequest);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public Page<MedicoResponse> listarMedicos(MedicoGetRequest filtros, Pageable paginacao) {
        return medicoService.listarMedicos(filtros, paginacao);
    }

    @GetMapping("/buscar/{medicoId}")
    @ResponseStatus(HttpStatus.OK)
    public MedicoResponse buscarMedico(@PathVariable Long medicoId) {
        return medicoService.buscarMedico(medicoId);
    }

    @DeleteMapping("/deletar/{medicoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMedico(@PathVariable Long medicoId) {
        medicoService.deletarMedico(medicoId);
    }
}
