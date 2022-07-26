package com.porfoliofinal.Lucia.Seguridad.Repositorio;

import com.porfoliofinal.Lucia.Seguridad.Entidad.Roles;
import com.porfoliofinal.Lucia.Seguridad.Enums.NombreRol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazSeguridadRep extends JpaRepository<Roles, Integer>{
  Optional<Roles> findByNombreRol(NombreRol nombreRol);
}
