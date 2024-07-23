package com.example.MiniProjeto.controllers;

import com.example.MiniProjeto.dtos.MedicoGetRequest;
import com.example.MiniProjeto.dtos.MedicoRequest;
import com.example.MiniProjeto.dtos.MedicoResponse;
import com.example.MiniProjeto.services.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        this.medicoService = medicoService;
    }

    @PostMapping("/cadastrar")
    public void cadastrarMedico(@RequestBody MedicoRequest medicoRequest){
        medicoService.cadastrarMedico(medicoRequest);
    }

    @PutMapping("/atualizar/{medicoId}")
    public void atualizarMedico(@PathVariable Long medicoId, @RequestBody MedicoRequest medicoRequest){
        medicoService.atualizarMedico(medicoId, medicoRequest);
    }

    @GetMapping("/listar")
    public Page<MedicoResponse> listarMedicos(MedicoGetRequest filtros, Pageable paginacao) {
        return medicoService.listarMedicos(filtros, paginacao);
    }

    @GetMapping("/buscar/{medicoId}")
    public MedicoResponse buscarMedico(@PathVariable Long medicoId) {
        return medicoService.buscarMedico(medicoId);
    }

    @DeleteMapping("/deletar/{medicoId}")
    public void deletarMedico(@PathVariable Long medicoId) {
        medicoService.deletarMedico(medicoId);
    }
}
