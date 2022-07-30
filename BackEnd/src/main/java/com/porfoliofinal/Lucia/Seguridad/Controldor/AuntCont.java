/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfoliofinal.Lucia.Seguridad.Controldor;

import com.porfoliofinal.Lucia.Seguridad.Dto.Dto;
import com.porfoliofinal.Lucia.Seguridad.Dto.LoginUsuario;
import com.porfoliofinal.Lucia.Seguridad.Dto.NuevoUsuario;
import com.porfoliofinal.Lucia.Seguridad.Entidad.Roles;
import com.porfoliofinal.Lucia.Seguridad.Entidad.Usuarios;
import com.porfoliofinal.Lucia.Seguridad.Enums.NombreRol;
import com.porfoliofinal.Lucia.Seguridad.Servicio.RolSer;
import com.porfoliofinal.Lucia.Seguridad.Servicio.UsuarioSer;
import com.porfoliofinal.Lucia.Seguridad.jwt.Provider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Auth")
@CrossOrigin

public class AuntCont {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioSer usuarioSer;
    @Autowired
    RolSer rolSer;
    @Autowired
    Provider provider;

    //Crear un usuario nuevo//
    @PostMapping("/nuevo")

    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) 
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"),HttpStatus.BAD_REQUEST);
       
        if (usuarioSer.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) 
            return new ResponseEntity(new Mensaje("Este nombre de usuariio ya existe"), HttpStatus.BAD_REQUEST);
       
        if (usuarioSer.existsByNombreUsuario(nuevoUsuario.getMail())) 
            return new ResponseEntity(new Mensaje("Este mail ya existe"),HttpStatus.BAD_REQUEST);
        
        Usuarios usuarios = new Usuarios(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getMail(), passwordEncoder.encode(nuevoUsuario.getContrasena()));

        Set<Roles> roles = new HashSet<>();
        roles.add(rolSer.getByNombreRol(NombreRol.ROL_USER).get());

        if (nuevoUsuario.getRoles().contains("admin")) 
            roles.add(rolSer.getByNombreRol(NombreRol.ROL_ADMIN).get());
            usuarios.setRoles(roles);
            usuarioSer.save(usuarios);

            return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }

        @PostMapping("/login")

        public ResponseEntity<Dto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors()) 
            return new ResponseEntity(new Mensaje("Campo mal puesto"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getContrasena()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = provider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Dto dto = new Dto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(dto, HttpStatus.OK); 
        
        }

}
