package it.corso.spb01.controller;


import it.corso.spb01.model.User;
import it.corso.spb01.model.Course;
import it.corso.spb01.repository.CourseRepository;
import it.corso.spb01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/controllerUser")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRepository;


    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers (){
        List<User> uArrayList = new ArrayList<User>();
        userRepository.findAll().forEach(uArrayList::add);
        if (uArrayList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(uArrayList, HttpStatus.OK);
    }


    @PostMapping("/insert")
    public ResponseEntity<User> createUser(@RequestBody User u) {
        User insertedU = userRepository.save(u);
        return new ResponseEntity<>(insertedU, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    //add course to user
    @PostMapping("/insertCourse/{userId}/{courseId}")
    public ResponseEntity<User> addCourse(@PathVariable(value = "userId") Long userId, @PathVariable(value = "courseId") Long courseId) {
        //prendi corso by id
        Course courseToAdd = courseRepository.findById(courseId).orElse(null);
        User choosenUser = userRepository.findById(userId).orElse(null);

        System.out.println("corso" + courseToAdd.toString());
        System.out.println("user" + choosenUser.toString());

        if( courseToAdd != null && choosenUser != null){
            choosenUser.addCourse(courseToAdd);
            //courseToAdd.addUser(choosenUser);


            userRepository.save(choosenUser);
            return new ResponseEntity<>(choosenUser, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
