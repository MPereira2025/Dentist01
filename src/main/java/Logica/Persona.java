/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Date;

/**
 *
 * @author massi
 */
public class Persona {
    
    private String name;
    private String lastName;
    private int tel;
    private String address;
    private Date dateBorn;

    public Persona() {
    }

    public Persona(String name, String lastName, int tel, String address, Date dateBorn) {
        
        this.name = name;
        this.lastName = lastName;
        this.tel = tel;
        this.address = address;
        this.dateBorn = dateBorn;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }
    
    
}
