package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.repositorios.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PersonaServicioImpl implements PersonaServicio{

    @Autowired
    private final PersonaRepo personaRepo;

    public PersonaServicioImpl(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }


    @Override
    public Persona login(String email, String password) throws Exception {
        Optional<Persona> persona = personaRepo.findByEmailAndPassword(email,password);

        if(persona.isEmpty())
        {
            throw new Exception("Los datos de autenticación son incorrectos");
        }

        return persona.get();
    }

}
