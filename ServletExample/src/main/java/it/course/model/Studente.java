package it.course.model;

public class Studente {

    private String nome;
    private String cognome;
    private String email;
    private String password;

    //constructor
    public Studente(){
        nome = "jaco";
        cognome = "orse";
        email = "jaco@mail";
        password = "123";
    }

    //getter e setter
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }


}
