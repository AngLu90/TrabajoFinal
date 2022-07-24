package com.porfoliofinal.Lucia.Controlador;

import com.porfoliofinal.Lucia.Entidad.Persona;
import com.porfoliofinal.Lucia.Interface.InterfazPersonaSer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PersonaCont {
    @Autowired InterfazPersonaSer interfazPersonaSer;
    
    @GetMapping("/persona/traer")
    public List<Persona> getPersona(){
        return interfazPersonaSer.getPersona();
    }

   
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
         interfazPersonaSer.savePersona(persona);
         return "La persona se ha registrado con éxito"; 
    }

    @DeleteMapping("/persona/borrar/{id}")
     public String deletePersona(@PathVariable("id") Long  id){
          interfazPersonaSer.deletePersona(id);
          return "La persona fue eliminada con éxito";
     }
   
    @PutMapping("/persona/editar/{id}") 
    public Persona editPersona(@PathVariable("id") Long id,
                               @RequestParam("nombre") String nombreNew,
                               @RequestParam("apellido") String apellidoNew,
                               @RequestParam("img") String imgNew){
        Persona persona = interfazPersonaSer.findPersona(id);
        persona.setNombre(nombreNew);
        persona.setApellido(apellidoNew);
        persona.setImg(imgNew);        
        
        interfazPersonaSer.savePersona(persona);
        return persona;
    }
}
