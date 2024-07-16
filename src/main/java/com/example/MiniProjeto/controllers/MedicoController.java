package com.example.MiniProjeto.controllers;

import com.example.MiniProjeto.dtos.MedicoRequest;
import com.example.MiniProjeto.services.MedicoService;
import jakarta.websocket.server.PathParam;
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
}
