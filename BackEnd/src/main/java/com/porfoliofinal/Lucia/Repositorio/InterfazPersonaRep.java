package com.porfoliofinal.Lucia.Repositorio;

import com.porfoliofinal.Lucia.Entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazPersonaRep extends JpaRepository<Persona,Long>{
    
}
