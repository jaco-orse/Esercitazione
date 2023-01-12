package it.corso.spb01.services;

import it.corso.spb01.model.Course;
import it.corso.spb01.model.Ruolo;
import it.corso.spb01.model.User;
import it.corso.spb01.payload.request.SignupRequest;

import java.util.ArrayList;
import java.util.Set;

public interface UserService {
    public ArrayList<User> getUsers();
    public User getUserById(Long id);
    public void setUserRoles(User user, Set<String> strRoles) throws Exception;
    public Boolean checkUserName(String nome);
    public Boolean checkUserMail(String mail);
    public void addNewBasicUser(SignupRequest signUpRequest);
    public void deleteUser(Long id);
    public Set<Ruolo> getUserRoles(Long id);
    public Set<Course> getUserCourses (Long id);
    public Boolean addUserCourse(Long courseId, Long userId);
}
