/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.abmlconSpringBootJPAHibernate.controller;

import com.example.abmlconSpringBootJPAHibernate.model.Persona;
import com.example.abmlconSpringBootJPAHibernate.model.Usuario;
import com.example.abmlconSpringBootJPAHibernate.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */
@RestController
public class PersonaController {

    @Autowired
    private IPersonaService interPersona;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return interPersona.getPersonas();
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona perso) {
        interPersona.savePersona(perso);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        interPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("edad") int nuevaEdad) {
        Persona perso = interPersona.findPersona(id);
        
        perso.setApellido(nuevoApellido);
        perso.setNombre(nuevoNombre);
        perso.setEdad(nuevaEdad);
        
        interPersona.savePersona(perso);
        return perso;
    }
    
/*    @PostMapping("/sesionInicioIrrestricto")
    public ResponseEntity sesion(
            @RequestParam("username") String username,
            @RequestParam("password") String password
            ){
//       return new ResponseEntity("{\"msg\":\"¡¡¡Dale pa delante no más!!!\"}",null, HttpStatus.OK);
       return new ResponseEntity("{\"msg\":\"¡¡¡Dale pa delante no más!!!\"}",null, HttpStatus.OK);
    }*/
    
/*    @RequestMapping(value = "/sesionInicioIrrestricto", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity sesion(
            @RequestParam("username") String username,
            @RequestParam("password") String password
            ){
//       return new ResponseEntity("{\"msg\":\"¡¡¡Dale pa delante no más!!!\"}",null, HttpStatus.OK);
       return new ResponseEntity("{\"msg\":\"¡¡¡Dale pa delante no más!!!\"}",null, HttpStatus.OK);
    }*/
    
    @PostMapping("/sesionInicioIrrestricto")
    public Usuario sesion(@RequestBody Usuario miusuario){
        return miusuario;
    }
}
