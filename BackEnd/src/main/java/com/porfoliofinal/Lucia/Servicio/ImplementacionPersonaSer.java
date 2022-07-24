package com.porfoliofinal.Lucia.Servicio;
import java.util.List;
import com.porfoliofinal.Lucia.Entidad.Persona;
import com.porfoliofinal.Lucia.Interface.InterfazPersonaSer;
import com.porfoliofinal.Lucia.Repositorio.InterfazPersonaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionPersonaSer implements InterfazPersonaSer{
@Autowired InterfazPersonaRep interfazPersonaRep;

    @Override
    public List<Persona> getPersona() {
    List<Persona> persona= interfazPersonaRep.findAll();
    return persona;
    }

    @Override
    public void savePersona(Persona persona) {
    interfazPersonaRep.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
    interfazPersonaRep.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
    Persona persona = interfazPersonaRep.findById(id).orElse(null);
    return persona;
    }
     
}
