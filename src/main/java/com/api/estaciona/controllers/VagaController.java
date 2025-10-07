package com.api.estaciona.controllers;

import com.api.estaciona.dtos.VagaDto;
import com.api.estaciona.models.UsuarioModel;
import com.api.estaciona.models.VagaModel;
import com.api.estaciona.repositories.UsuarioRepository;
import com.api.estaciona.service.VagaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/vaga")

public class VagaController {
    private final VagaService vagaService;
    private final UsuarioRepository usuarioRepository;

    public VagaController(VagaService vagaService, UsuarioRepository usuarioRepository) {
        this.vagaService = vagaService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody @Valid VagaDto dto) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(dto.getUsuarioId());
        if (!usuario.isPresent()) {
            return ResponseEntity.badRequest().body(
                    "Usuário não encontrado" + dto.getUsuarioId()
            );
        }

        VagaModel vaga = new VagaModel();
        BeanUtils.copyProperties(dto, vaga, "id", "usuarioModel");
        vaga.setUsuarioModel(usuario.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(vagaService.salvar(vaga));
    }

    @GetMapping("/listar")
    public List<VagaModel> listar() {
        return vagaService.listar();
    }

    @PostMapping("/apagar/{id}")
    public ResponseEntity<String> apagar(@PathVariable UUID id) {
        try {
            vagaService.excluir(id);
            return ResponseEntity.ok("Vaga apagado com sucesso!");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Deu ruim: " + e.getMessage());
        }
    }

}
