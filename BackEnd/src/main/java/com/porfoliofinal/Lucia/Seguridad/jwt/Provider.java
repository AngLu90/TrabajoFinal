package com.porfoliofinal.Lucia.Seguridad.jwt;

import com.porfoliofinal.Lucia.Seguridad.Entidad.Usuario1;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import jdk.internal.icu.impl.ICUBinary.Authenticate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component

public class Provider {

    private final static Logger logger = LoggerFactory.getLogger(Provider.class);

    @Value("${Jwt.secret}")
    private String secret;
    @Value("${Jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        Usuario1 usuario1 = (Usuario1) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuario1.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNombreUsuarioFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Token Mal Formado");
        } catch (UnsupportedJwtException e) {
            logger.error("Token No Soportado");
        } catch (ExpiredJwtException e) {
            logger.error("Token Expirado");
        } catch (IllegalArgumentException e) {
            logger.error("Token Vacio");
        } catch (SignatureException e) {
            logger.error("Firma no válida");
        }
        return false;
    }
}
