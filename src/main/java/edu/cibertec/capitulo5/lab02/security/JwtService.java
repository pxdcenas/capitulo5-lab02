package edu.cibertec.capitulo5.lab02.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(String username) {
        Date nowDate = new Date();
        Date expiryDate = new Date(nowDate.getTime() + 300000); // 5 minutes later

        JwtBuilder builder = Jwts.builder()
                .claim(Claims.SUBJECT, username)
                .claim(Claims.ISSUED_AT, nowDate)
                .claim(Claims.EXPIRATION, expiryDate)
                .signWith(key);

        return builder.compact();
    }

    public String validateToken(String token) {
        SecretKey secretKey = Keys.hmacShaKeyFor(key.getEncoded());
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token).getPayload().getSubject();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
//        return Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
        SecretKey secretKey = Keys.hmacShaKeyFor(key.getEncoded());
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token).getPayload();
    }
}
