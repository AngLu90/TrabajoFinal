package com.porfoliofinal.Lucia.Seguridad.Servicio;

import com.porfoliofinal.Lucia.Seguridad.Entidad.Usuarios;
import com.porfoliofinal.Lucia.Seguridad.Repositorio.InterfazUsuariosRep;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class UsuarioSer {

    @Autowired
    InterfazUsuariosRep interfazUsuariosRep;

    public Optional<Usuarios> getByNombreUsuario(String nombreUsuario) {
        return interfazUsuariosRep.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return interfazUsuariosRep.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByMail(String mail) {
        return interfazUsuariosRep.existsByMail(mail);
    }

    public void save(Usuarios usuarios) {
        interfazUsuariosRep.save(usuarios);
    }
}
