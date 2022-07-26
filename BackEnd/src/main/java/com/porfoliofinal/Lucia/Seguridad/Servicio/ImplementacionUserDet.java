package com.porfoliofinal.Lucia.Seguridad.Servicio;

import com.porfoliofinal.Lucia.Seguridad.Entidad.Usuario1;
import com.porfoliofinal.Lucia.Seguridad.Entidad.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class ImplementacionUserDet implements UserDetailsService {

    @Autowired
    UsuarioSer usuarioSer;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
       Usuarios usuarios = usuarioSer.getByNombreUsuario(nombreUsuario).get();
       return Usuario1.build(usuarios);
    }
}

