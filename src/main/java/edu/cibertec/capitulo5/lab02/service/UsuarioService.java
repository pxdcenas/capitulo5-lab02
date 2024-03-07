package edu.cibertec.capitulo5.lab02.service;

import edu.cibertec.capitulo5.lab02.model.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario);

    Optional<Usuario> buscarUsuarioPorUsername(String username);
}
