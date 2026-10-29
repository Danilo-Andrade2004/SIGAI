package com.nc.sigai.usuarios.service;

import org.springframework.stereotype.Service;

import com.nc.sigai.usuarios.dto.UsuarioResponseDTO;
import com.nc.sigai.usuarios.exception.UsuarioNaoEncontradoException;
import com.nc.sigai.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        return usuarioRepository.findById(id)
            .map(UsuarioResponseDTO::from)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }
}