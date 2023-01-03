package it.myexample.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tabella")
public class classeEsempio {

    //attributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    //costruttore
    public classeEsempio(){}

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
}
