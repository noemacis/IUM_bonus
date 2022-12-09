package com.example.ium_bonus;
import java.io.Serializable;
import java.util.Calendar;

public class Persona implements Serializable {
    private String username;
    private String password;
    private Calendar bitrthDate;
    private String citta;

    public Persona(){
        this.setUsername(""); ;
        this.setPassword("");
        this.setCitta("");
    }


    public Persona(String username, String password, Calendar bitrthDate, String citta) {
        this.username = username;
        this.password = password;
        this.bitrthDate = bitrthDate;
        this.citta = citta;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getBitrthDate() {
        return bitrthDate;
    }

    public void setBitrthDate(Calendar bitrthDate) {
        this.bitrthDate = bitrthDate;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
