/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author massi
 */
@Entity
public class Secretario extends Persona{
    private String sector;
    @OneToOne
    private Usuario anUser;

    public Secretario() {
    }

    public Secretario(String sector, Usuario anUser, int id, String name, String lastName, int tel, String address, Date dateBorn) {
        super(id, name, lastName, tel, address, dateBorn);
        this.sector = sector;
        this.anUser = anUser;
    }

   

   /* public int getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(int idSecretario) {
        this.idSecretario = idSecretario;
    }*/

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
