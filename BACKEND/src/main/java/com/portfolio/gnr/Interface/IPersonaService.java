package com.portfolio.gnr.Interface;

import com.portfolio.gnr.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Traer una lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto de tipo Persona, buscandolo por Id
    public void deletePersona(Long id);
    
    //Buscar una persona por Id
    public Persona finfPersona(Long id);
}
