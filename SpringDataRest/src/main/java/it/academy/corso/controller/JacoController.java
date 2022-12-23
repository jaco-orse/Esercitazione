package it.academy.corso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class JacoController {

    @GetMapping("/hiJaco")
    public ResponseEntity<String> hiJaco(){
        String message = "Jaco";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }



    @GetMapping("/hiJaco2")
    public ResponseEntity<Map<String,String>> hiJaco2 (){
        Map <String,String> value = new HashMap();
        value.put("name","Jaco");
        return new ResponseEntity<>(value, HttpStatus.OK);
    }


}
