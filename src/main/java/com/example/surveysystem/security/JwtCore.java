package com.example.surveysystem.security;
import com.example.surveysystem.models.Man;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
@Component
public class JwtCore {
    @Value("${surveysystem.app.secret}")
    private String secret;
    @Value("${surveysystem.app.lifetime}")
    private int lifetime;

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("id", ((UserDetailsImpl) userDetails).getManId())
                .claim("name", userDetails.getUsername())
                .claim("roles", ((UserDetailsImpl) userDetails).getRoles())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date().getTime() + lifetime)))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    public String getNameFromJwt(String token) {
        return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(token).getBody().getSubject();
    }}