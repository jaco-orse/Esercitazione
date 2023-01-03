package it.corso.spb01.controller;

import it.corso.spb01.model.Course;
import it.corso.spb01.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Course>> getCourseById(@PathVariable("id") long id) {
        Optional<Course> curr = courseRepository.findById(id);
        if(curr.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Optional<Course>>(curr, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Course> createCourse(@RequestBody Course corso) {
        Course _corso = courseRepository.save(corso);
        return new ResponseEntity<>(_corso, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCoure(@PathVariable("id") long id) {
        courseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course newCourse) throws Exception {
        Course currCourse = courseRepository.findById(id).orElseThrow(() -> new Exception("TagId " + id + "not found"));
        currCourse.setName(newCourse.getName());
        return new ResponseEntity<>(courseRepository.save(currCourse), HttpStatus.OK);
    }





}

