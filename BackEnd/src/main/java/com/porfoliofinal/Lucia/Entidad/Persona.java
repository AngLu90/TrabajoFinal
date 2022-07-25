package com.porfoliofinal.Lucia.Entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=1, max=50, message="No cumle con la longitud")
    private String nombre;
    @NotNull
    @Size(min=1, max=50, message="No cumle con la longitud")
    private String apellido;
    @NotNull
    @Size(min=1, max=150, message="No cumle con la longitud")
    private String descr;
    @NotNull
    //@Size(min=1, max=2000000, message="No cumle con la longitud")
    private String acerca;
    @Size(min=1, max=50, message="No cumle con la longitud")
    private String img; 
    
 }

