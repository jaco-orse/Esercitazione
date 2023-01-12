package it.corso.spb01.services.impl;

import it.corso.spb01.model.Course;
import it.corso.spb01.model.Ruolo;
import it.corso.spb01.model.User;
import it.corso.spb01.model.enumRuolo;
import it.corso.spb01.payload.request.SignupRequest;
import it.corso.spb01.repository.CourseRepository;
import it.corso.spb01.repository.RuoloRepository;
import it.corso.spb01.repository.UserRepository;
import it.corso.spb01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RuoloRepository roleRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    PasswordEncoder encoder;

    public UserServiceImp(){}

    public ArrayList<User> getUsers(){
        ArrayList<User> uArrayList = new ArrayList<User>();
        userRepository.findAll().forEach(uArrayList::add);
        return uArrayList;
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void setUserRoles(User user, Set<String> strRoles) throws Exception{
        Set<Ruolo> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Ruolo adminRole = roleRepository.findByName(enumRuolo.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);

                    break;
                case "mod":
                    Ruolo modRole = roleRepository.findByName(enumRuolo.ROLE_MODERATOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(modRole);

                    break;
                default:
                    Ruolo userRole = roleRepository.findByName(enumRuolo.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
            }
        });
        user.setRoles(roles);
        userRepository.save(user);
    }


    public Boolean checkUserName(String nome){
        if(userRepository.existsByName(nome)){
            return false;
        }
        return true;
    }

    public Boolean checkUserMail(String mail){
        if(userRepository.existsByEmail(mail)){
            return false;
        }
        return true;
    }

    public void addNewBasicUser(SignupRequest signUpRequest){
        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Ruolo> roles = new HashSet<>();

        if (strRoles == null) {
            Ruolo userRole = roleRepository.findByName(enumRuolo.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Ruolo adminRole = roleRepository.findByName(enumRuolo.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Ruolo modRole = roleRepository.findByName(enumRuolo.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Ruolo userRole = roleRepository.findByName(enumRuolo.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
        return;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public Set<Ruolo> getUserRoles(Long id){
        Set<Ruolo> roleArrayList;
        User choosenUser = userRepository.findById(id).orElse(null);
        if (choosenUser == null) {
            return null;
        }
        roleArrayList = choosenUser.getRoles();
        return roleArrayList;
    }

    public Set<Course> getUserCourses (Long id){
        User choosenUser = userRepository.findById(id).orElse(null);
        if (choosenUser == null) {
            return null;
        }
        return choosenUser.getCourses();
    }

    public Boolean addUserCourse(Long courseId, Long userId){
        Course courseToAdd = courseRepository.findById(courseId).orElse(null);
        User choosenUser = userRepository.findById(userId).orElse(null);
        if( courseToAdd != null && choosenUser != null){
            choosenUser.addCourse(courseToAdd);
            //courseToAdd.addUser(choosenUser);
            //courseRepository.save(courseToAdd);
            userRepository.save(choosenUser);
            return true;
        }
        return false;
    }

}
