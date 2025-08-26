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
public class Secretario extends Persona{
    private int idSecretario;
    private String sector;
    private Usuario anUser;

    public Secretario() {
    }

    public Secretario(int idSecretario, String sector, Usuario anUser, String name, String lastName, int tel, String address, Date dateBorn) {
        super(name, lastName, tel, address, dateBorn);
        this.idSecretario = idSecretario;
        this.sector = sector;
        this.anUser = anUser;
    }

    public int getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(int idSecretario) {
        this.idSecretario = idSecretario;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Usuario getAnUser() {
        return anUser;
    }

    public void setAnUser(Usuario anUser) {
        this.anUser = anUser;
    }
    
    
    
    
}
