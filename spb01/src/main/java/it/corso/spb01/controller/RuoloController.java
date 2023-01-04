package it.corso.spb01.controller;

import it.corso.spb01.model.Ruolo;
import it.corso.spb01.repository.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        ArrayList<Ruolo> _roles = (ArrayList<Ruolo>) roleRepository.findAll();
        return new ResponseEntity<>(_roles, HttpStatus.OK);
    }

    @PostMapping("/insertRole")
    public ResponseEntity<Ruolo> createRuolo(@RequestBody Ruolo role) {
        Ruolo _role = roleRepository.save(role);
        return new ResponseEntity<Ruolo>(_role, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRole/{id}")
    public ResponseEntity<HttpStatus> deleteRuolo(@PathVariable long id) {
        roleRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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