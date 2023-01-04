package it.corso.spb01.model;


import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "password")
    }
)
public class User {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "email")
    @Size(max = 100)
    private String email;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "password")
    @Size(max = 100)
    private String password;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
            })
    @JoinTable(name = "user_course",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") })
    private Set<Course> courses = new HashSet<>();



    //metodi
    public Set<Course> getCourses(){ return this.courses; }

    public void addCourse(Course c) {
        this.courses.add(c);
        c.addUser(this);
    }

    public void removeCourse(long courseID) {
        Course c = this.courses.stream().filter(t -> t.getId() == courseID).findFirst().orElse(null);
        if(c != null){
            this.courses.remove(c);
            c.getUsers().remove(this);
        }
    }




}
