package it.corso.spb01.controller;

import it.corso.spb01.model.Esame;
import it.corso.spb01.services.EsameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controllerEsame")
public class EsameController {
    @Autowired
    EsameService esameService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Esame>> getEsame(){
        try{
            List<Esame> esami = esameService.getAll();
            return new ResponseEntity<>(esami, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/getAllbyValutazione/{val}")
    public ResponseEntity<List<Esame>> getEsameByVal (@PathVariable("val") int val){
        List<Esame> esami = esameService.getAllbyValutazione(val);
        if(esami.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(esami, HttpStatus.OK);
    }

    @PostMapping("/insertEsame/{corsoId}")
    public ResponseEntity<?> createEsame(@PathVariable("corsoId") long corsoId, @RequestBody Esame e) {
        try{
            esameService.insertExam(e,corsoId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(DataAccessException exc){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEsame(@PathVariable("id") long id) {
        try{
            esameService.deleteEsame(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
