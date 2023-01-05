package it.corso.spb01.services;

import it.corso.spb01.model.Ruolo;
import it.corso.spb01.model.User;
import it.corso.spb01.model.enumRuolo;
import it.corso.spb01.repository.RuoloRepository;
import it.corso.spb01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RuoloRepository roleRepository;

    public UserService(){}

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

}
