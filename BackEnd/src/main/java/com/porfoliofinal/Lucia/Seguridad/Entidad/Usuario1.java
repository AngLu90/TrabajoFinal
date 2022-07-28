package com.porfoliofinal.Lucia.Seguridad.Entidad;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Usuario1 implements UserDetails {

    private String nombre;
    private String nombreUsuario;
    private String mail;
    private String contrasena;
    private Collection<? extends GrantedAuthority> authentication;

    public Usuario1() {
    }

    public Usuario1(String nombre, String nombreUsuario, String mail, String contrasena, Collection<? extends GrantedAuthority> aut) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.mail = mail;
        this.contrasena = contrasena;
        this.authentication = authentication;
    }
  
        public static Usuario1 build(Usuarios usuarios) {
        List<GrantedAuthority> authentication;
        authentication = usuarios.getRoles().stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getNombreRol().name())).collect(Collectors
                .toList());
        return new Usuario1(usuarios.getNombre(), usuarios.getNombreUsuario(), usuarios.getMail(), usuarios.getContrasena(), authentication);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authentication;
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
