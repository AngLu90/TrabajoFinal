package com.porfoliofinal.Lucia.Seguridad.jwt;

import com.porfoliofinal.Lucia.Seguridad.Entidad.Usuario1;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import jdk.internal.icu.impl.ICUBinary.Authenticate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Provider {

    private final static Logger logger = LoggerFactory.getLogger(Provider.class);

    @Value("Jwt.secret")
    private String secret;
    @Value("Jwt.expiration")
    private int expiration;

    public String generateToken(Authenticate authenticate) {
        Usuario1 usuario1 = (Usuario1) authenticate.getPrincipal();
        return Jwts.builder().setSubject(usuario1.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

}
