package it.corso.spb01.controller;

import it.corso.spb01.model.Course;
import it.corso.spb01.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/controllerCourse")

public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Course>> getCourses (){
        List<Course> studentArrayList = courseService.getCourses();
        if (studentArrayList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentArrayList, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") long id) {

        try{
            Course curr = courseService.getCorseByID(id);
            //if(curr.isEmpty()){
            //  return new ResponseEntity<Optional<Course>>(HttpStatus.NO_CONTENT);
            //}
            return new ResponseEntity<Course>(curr, HttpStatus.OK);
        }catch (DataAccessException e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/insert")
    public ResponseEntity<Course> createCourse(@RequestBody Course corso) {
        try{
            Course _corso = courseService.addCourse(corso);
            return new ResponseEntity<>(_corso, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {
        try {
            courseService.deleteCourse(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course newCourse) {
        try{
            Course c = courseService.updateCourse(id,newCourse);
            return new ResponseEntity<>(c, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<Map<String,String>> uploadFile(@PathVariable Long id , @RequestParam("file") MultipartFile data) {
        try {
            courseService.uploadFile(id,data);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String,String> map = new HashMap<>();
            String message = "Non posso caricare il file: " + data.getOriginalFilename();
            map.put("Error",message);
            return new ResponseEntity<>(map, HttpStatus.EXPECTATION_FAILED);

        }
    }

    @PutMapping("/deleteFile/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable Long id){
        try{
            courseService.deleteFile(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            String message = "Non posso eliminare il file"+e.getMessage();
            return new ResponseEntity<>(message, HttpStatus.EXPECTATION_FAILED);
        }
    }


}

