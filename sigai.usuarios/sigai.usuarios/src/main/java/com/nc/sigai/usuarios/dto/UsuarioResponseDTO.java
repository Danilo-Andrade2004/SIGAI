package com.nc.sigai.usuarios.dto;

import com.nc.sigai.usuarios.model.Role;
import com.nc.sigai.usuarios.model.Usuario;

public record UsuarioResponseDTO(String nome, String username, Role papel) {

    public static UsuarioResponseDTO from(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getNome(), usuario.getUsername(), usuario.getRole());
    }
}