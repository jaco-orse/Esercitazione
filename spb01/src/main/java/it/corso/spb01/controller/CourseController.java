package it.corso.spb01.controller;

import it.corso.spb01.model.Course;
import it.corso.spb01.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}

