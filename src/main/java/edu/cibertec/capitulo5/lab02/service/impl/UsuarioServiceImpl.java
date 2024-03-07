package edu.cibertec.capitulo5.lab02.service.impl;

import edu.cibertec.capitulo5.lab02.model.Usuario;
import edu.cibertec.capitulo5.lab02.repository.UsuarioRepository;
import edu.cibertec.capitulo5.lab02.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario " + username + " no encontrado");
        }
        Collection<GrantedAuthority> authorities = usuario.get().getRoles().stream()
                .map(role -> "ROLE_" + role.getDescripcion().toUpperCase())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());


        return new User(usuario.get().getUsername(), usuario.get().getPassword(), authorities);
    }
}
