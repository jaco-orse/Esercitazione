package it.corso.spb01.controller;

import it.corso.spb01.model.Ruolo;
import it.corso.spb01.repository.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/controllerRuolo")
public class RuoloController {
    @Autowired
    RuoloRepository roleRepository;

    @GetMapping("/getRoles")
    public ResponseEntity<ArrayList<Ruolo>> getRuoli() {
        try{
            ArrayList<Ruolo> _roles = (ArrayList<Ruolo>) roleRepository.findAll();
            return new ResponseEntity<>(_roles, HttpStatus.OK);
        }catch(DataAccessException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insertRole")
    public ResponseEntity<Ruolo> createRuolo(@RequestBody Ruolo role) {
        try {
            Ruolo _role = roleRepository.save(role);
            return new ResponseEntity<Ruolo>(_role, HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/deleteRole/{id}")
    public ResponseEntity<HttpStatus> deleteRuolo(@PathVariable long id) {
        try {
            roleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateRole/{id}")
    public ResponseEntity<Ruolo> updateRuolo(@PathVariable("id") long id, @RequestBody Ruolo role) {
        Ruolo _role = roleRepository.findById(id).orElse(null);
        if (_role == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        _role.setName(role.getName());
        return new ResponseEntity<>(roleRepository.save(_role), HttpStatus.OK);
    }
}