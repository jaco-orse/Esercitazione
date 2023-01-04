package it.corso.spb01.controller;


import it.corso.spb01.model.Ruolo;
import it.corso.spb01.model.User;
import it.corso.spb01.model.Course;
import it.corso.spb01.repository.CourseRepository;
import it.corso.spb01.repository.RuoloRepository;
import it.corso.spb01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/controllerUser")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    RuoloRepository roleRepository;


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

        if( courseToAdd != null && choosenUser != null){
            choosenUser.addCourse(courseToAdd);
            //courseToAdd.addUser(choosenUser);

            //courseRepository.save(courseToAdd);
            userRepository.save(choosenUser);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getCourses/{userId}")
    public ResponseEntity<Set<Course>> getCourses (@PathVariable(value = "userId") Long userId){
        Set<Course> courseArrayList;
        User choosenUser = userRepository.findById(userId).orElse(null);
        if (choosenUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        courseArrayList = choosenUser.getCourses();
        return new ResponseEntity<>(courseArrayList, HttpStatus.OK);
    }


    @GetMapping("/getRoles/{userId}")
    public ResponseEntity<Set<Ruolo>> getRoles(@PathVariable(value = "userId") Long userId){
        Set<Ruolo> roleArrayList;
        User choosenUser = userRepository.findById(userId).orElse(null);
        if (choosenUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        roleArrayList = choosenUser.getRoles();
        return new ResponseEntity<>(roleArrayList, HttpStatus.OK);
    }

    @PostMapping("/insertRoleToUser/{userId}")
    public ResponseEntity<User> addCourse(@PathVariable(value = "userId") Long userId, @RequestBody Ruolo role) {


        //System.out.println(role.getId());

        Ruolo r = roleRepository.findById(role.getId()).orElse(null);
        User choosenUser = userRepository.findById(userId).orElse(null);

        //System.out.println(r.getName().toString());

        if( r != null && choosenUser != null){
            choosenUser.addRole(r);

            User newU =  userRepository.save(choosenUser);


            return new ResponseEntity<>(newU,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}
