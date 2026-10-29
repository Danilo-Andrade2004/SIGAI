package com.nc.sigai.usuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nc.sigai.usuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}