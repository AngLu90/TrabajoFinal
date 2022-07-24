package com.porfoliofinal.Lucia.Interface;

import com.porfoliofinal.Lucia.Entidad.Persona;
import java.util.List;

public interface InterfazPersonaSer {
    
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
    
}
