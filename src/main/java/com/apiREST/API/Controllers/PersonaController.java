package com.apiREST.API.Controllers;

import com.apiREST.API.Models.Persona;
import com.apiREST.API.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping(value = "/personas")
    public List<Persona> getPersonas() { return personaRepository.findAll(); }

    @PostMapping(value = "/savePersona")
    public String savePersona(@RequestBody Persona persona) {
        personaRepository.save(persona);
        return "Usuario guardado correctamente";
    }

    @PutMapping(value = "/updatePersonaById/{id}")
    public String updatePersona(@PathVariable long id, @RequestBody Persona persona) {
        Persona updatedPersona = personaRepository.findById(id).get();
        updatedPersona.setNombre(persona.getNombre());
        updatedPersona.setApellido(persona.getApellido());
        updatedPersona.setDni(persona.getDni());
        personaRepository.save(updatedPersona);

        return "Usuario actualizado correctamente";
    }
}