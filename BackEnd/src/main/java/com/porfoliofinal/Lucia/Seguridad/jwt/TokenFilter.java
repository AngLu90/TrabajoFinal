package com.porfoliofinal.Lucia.Seguridad.jwt;

import com.porfoliofinal.Lucia.Seguridad.Servicio.ImplementacionUserDet;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class TokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(Provider.class);

    @Autowired
    Provider provider;

    @Autowired
    ImplementacionUserDet implementacionUserDet;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getToken(request);
            if (token != null && provider.validateToken(token)) {
                String nombreUsuario = provider.getNombreUsuarioFromToken(token);
                    UserDetails userDetails = ImplementacionUserDet.loadUsersByUsername(nombreUsuario);
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,
                            null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
            catch (Exception e){
                 logger.error("Falla metodo doFilterInternal");
                }
            filterChain.doFilter(request, response);
        }  

    

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) 
            return header.replace("Bearer", "");
            return null;
        }
    }
