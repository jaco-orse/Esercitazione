package it.corso.spb01.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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


    @Getter
    @Setter
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(length=100000)
    private byte[] data;

    @Getter
    @Setter
    private String type;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<User> users = new HashSet<User>();


    @OneToMany(mappedBy="course")
    private Set<Esame> esami;

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
