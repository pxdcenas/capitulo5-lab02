package edu.cibertec.capitulo5.lab02;

import edu.cibertec.capitulo5.lab02.model.Rol;
import edu.cibertec.capitulo5.lab02.model.Usuario;
import edu.cibertec.capitulo5.lab02.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UsuarioTests {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    void testRegistrarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setUsername("adminsql");
        //usuario.setPassword("adminsql");
        usuario.setPassword(new BCryptPasswordEncoder().encode("adminsql"));

        Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario);

        assertNotNull(usuarioRegistrado);
        assertEquals(usuario.getUsername(), usuarioRegistrado.getUsername());

    }

    @Test
    void testRegistrarUsuarioRolAdmin(){
        Usuario usuario = new Usuario();
        usuario.setUsername("adminsql");
        //usuario.setPassword("adminsql");
        usuario.setPassword(new BCryptPasswordEncoder().encode("adminsql"));

        Rol rol = new Rol();
        rol.setDescripcion("ADMIN");
        usuario.setRoles(List.of(rol));

        Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario);

        assertNotNull(usuarioRegistrado);
        assertEquals(usuario.getUsername(), usuarioRegistrado.getUsername());
        assertEquals(1, usuarioRegistrado.getRoles().size());

    }

    @Test
    void testRegistrarUsuarioRolUser(){
        Usuario usuario = new Usuario();
        usuario.setUsername("usersql");
        //usuario.setPassword("adminsql");
        usuario.setPassword(new BCryptPasswordEncoder().encode("usersql"));

        Rol rol = new Rol();
        rol.setDescripcion("USER");
        usuario.setRoles(List.of(rol));

        Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario);

        assertNotNull(usuarioRegistrado);
        assertEquals(usuario.getUsername(), usuarioRegistrado.getUsername());
        assertEquals(1, usuarioRegistrado.getRoles().size());

    }
}
