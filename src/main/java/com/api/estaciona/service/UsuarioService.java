package com.api.estaciona.service;

import com.api.estaciona.models.UsuarioModel;
import com.api.estaciona.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel salvar(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioModel> listar() {
        return usuarioRepository.findAll();
    }

    public void excluir(UUID id) {
        UsuarioModel usuarioEncontrado = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioRepository.deleteById(usuarioEncontrado.getId());
    }
}
