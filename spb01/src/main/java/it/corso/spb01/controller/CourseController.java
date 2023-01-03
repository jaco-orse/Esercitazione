package it.corso.spb01.controller;

import it.corso.spb01.model.Course;
import it.corso.spb01.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/controllerCourse")

public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Course>> getCourses (){
        List<Course> studentArrayList = new ArrayList<Course>();
        courseRepository.findAll().forEach(studentArrayList::add);
        if (studentArrayList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentArrayList, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Course> createCourse(@RequestBody Course corso) {
        Course _corso = courseRepository.save(corso);
        return new ResponseEntity<>(_corso, HttpStatus.CREATED);
    }

   // @DeleteMapping("/student/{id}")
   // public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id) {
   //     studentRepository.deleteById(id);
   //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   // }



}

