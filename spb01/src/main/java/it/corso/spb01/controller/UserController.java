package it.corso.spb01.controller;


import it.corso.spb01.model.Ruolo;
import it.corso.spb01.model.User;
import it.corso.spb01.model.Course;
import it.corso.spb01.payload.request.SignupRequest;
import it.corso.spb01.payload.response.MessageResponse;
import it.corso.spb01.repository.CourseRepository;
import it.corso.spb01.repository.RuoloRepository;
import it.corso.spb01.repository.UserRepository;
import it.corso.spb01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/controllerUser")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/getAll") //UTILIZZA USER SERVICE
    public ResponseEntity<List<User>> getUsers (){
        List<User> uArrayList = userService.getUsers();
        if (uArrayList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(uArrayList, HttpStatus.OK);
    }

/*
    @PostMapping("/insert")
    public ResponseEntity<User> createUser(@RequestBody User u) {
        User insertedU = userRepository.save(u);
        return new ResponseEntity<>(insertedU, HttpStatus.CREATED);
    }
*/
    @DeleteMapping("/delete/{id}") //UTILIZZA USER SERVICE
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        try{
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping("/insertCourse/{userId}/{courseId}")
    public ResponseEntity<User> addCourse(@PathVariable(value = "userId") Long userId, @PathVariable(value = "courseId") Long courseId) {
        if(userService.addUserCourse(courseId,userId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getCourses/{userId}")  //UTILIZZA USER SERVICE
    public ResponseEntity<Set<Course>> getCourses (@PathVariable(value = "userId") Long userId){
        Set<Course> courseArrayList;
        courseArrayList = userService.getUserCourses(userId);
        if(courseArrayList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courseArrayList, HttpStatus.OK);
    }

/*
    @PostMapping("/insertRoleToUser/{userId}")
    public ResponseEntity<User> addRole(@PathVariable(value = "userId") Long userId, @RequestBody Ruolo role) {

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
*/
    @PostMapping("/insertRole2/{userId}") //UTILIZZA USER SERVICE
    public ResponseEntity<?> addRole2(@PathVariable(value = "userId") Long userId, @RequestBody SignupRequest signUpRequest) throws Exception {

        User user = userService.getUserById(userId);
        if( user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Set<String> strRoles = signUpRequest.getRole();
        try{
            userService.setUserRoles(user,strRoles);
            return ResponseEntity.ok(new MessageResponse("oook"));
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/getRoles/{userId}") //UTILIZZA USER SERVICE
    public ResponseEntity<Set<Ruolo>> getRoles(@PathVariable(value = "userId") Long userId){
        try {
            Set<Ruolo> roleArrayList = userService.getUserRoles(userId);
            return new ResponseEntity<>(roleArrayList, HttpStatus.OK);
        }
        catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
