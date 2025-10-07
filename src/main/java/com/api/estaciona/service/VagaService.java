package com.api.estaciona.service;

import com.api.estaciona.models.VagaModel;
import com.api.estaciona.repositories.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VagaService {
    final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    public VagaModel salvar(VagaModel vaga) {
        return vagaRepository.save(vaga);
    }

    public List<VagaModel> listar() {
        return vagaRepository.findAll();
    }

    public void excluir(UUID id) {
        VagaModel vagaEncontrada = vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        vagaRepository.deleteById(vagaEncontrada.getId());
    }


}
