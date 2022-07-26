package com.porfoliofinal.Lucia.Seguridad.Repositorio;

import com.porfoliofinal.Lucia.Seguridad.Entidad.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazUsuariosRep extends JpaRepository<Usuarios, Integer>{
     Optional<Usuarios> findByNombreUsuarios(String nombreUsuarios);
 
boolean existsByNombreUsuarios(String nombreUsuarios);
boolean existsByMail(String mail);

    public Optional<Usuarios> findByNombreUsuario(String nombreUsuario);

    public boolean existsByNombreUsuario(String nombreUsuario);
}
