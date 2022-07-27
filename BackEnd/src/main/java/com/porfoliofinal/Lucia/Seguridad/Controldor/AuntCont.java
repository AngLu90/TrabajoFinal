/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfoliofinal.Lucia.Seguridad.Controldor;

import com.porfoliofinal.Lucia.Seguridad.Servicio.RolSer;
import com.porfoliofinal.Lucia.Seguridad.Servicio.UsuarioSer;
import com.porfoliofinal.Lucia.Seguridad.jwt.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}


