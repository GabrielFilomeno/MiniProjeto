package com.example.MiniProjeto.controllers;

import com.example.MiniProjeto.dtos.MedicoRequest;
import com.example.MiniProjeto.services.MedicoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
