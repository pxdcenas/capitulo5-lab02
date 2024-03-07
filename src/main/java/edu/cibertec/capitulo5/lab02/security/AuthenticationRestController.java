package edu.cibertec.capitulo5.lab02.security;


import edu.cibertec.capitulo5.lab02.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRestController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Usuario usuario) throws Exception {
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(usuario.getUsername());
        return ResponseEntity.ok(jwtService.generateToken(userDetails.getUsername()));
    }
}
