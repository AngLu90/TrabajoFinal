package com.porfoliofinal.Lucia.Seguridad.Servicio;

import com.porfoliofinal.Lucia.Seguridad.Entidad.Roles;
import com.porfoliofinal.Lucia.Seguridad.Enums.NombreRol;
import com.porfoliofinal.Lucia.Seguridad.Repositorio.InterfazSeguridadRep;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolSer {

    @Autowired
    InterfazSeguridadRep interfazSeguridadRep;

    public Optional<Roles> getByNombreRol(NombreRol nombreRol) {
        return interfazSeguridadRep.findByNombreRol(nombreRol);
    }
    
    public void save(Roles roles){
        interfazSeguridadRep.save(roles);
    }
    
}
