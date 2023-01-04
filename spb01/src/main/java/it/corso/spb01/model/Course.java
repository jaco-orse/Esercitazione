package it.corso.spb01.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.REMOVE
            })
    @JoinTable(name = "user_course",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> users = new HashSet<User>();

    public Course(){}


    //getter e setter
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<User> getUsers(){
        return this.users;
    }
    public void addUser(User u){
        this.users.add(u);
        //u.addCourse(this);
    }
    public void removeUser(long userID){
        User u = this.users.stream().filter(t -> t.getId() == userID).findFirst().orElse(null);
        if(u != null){
            this.users.remove(u);
            u.getCourses().remove(this);
        }
    }

}
