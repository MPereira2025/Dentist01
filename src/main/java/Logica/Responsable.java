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
public class Responsable extends Persona{
    private int idResponsable;
    private String typeResponsable;
    private Paciente anPaciente;

    public Responsable() {
    }

    public Responsable(int idResponsable, String typeResponsable, Paciente anPaciente, String name, String lastName, int tel, String address, Date dateBorn) {
        super(name, lastName, tel, address, dateBorn);
        this.idResponsable = idResponsable;
        this.typeResponsable = typeResponsable;
        this.anPaciente = anPaciente;
    }

    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getTypeResponsable() {
        return typeResponsable;
    }

    public void setTypeResponsable(String typeResponsable) {
        this.typeResponsable = typeResponsable;
    }

    public Paciente getAnPaciente() {
        return anPaciente;
    }

    public void setAnPaciente(Paciente anPaciente) {
        this.anPaciente = anPaciente;
    }
    
}
