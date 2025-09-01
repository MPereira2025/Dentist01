/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Usuario;

/**
 *
 * @author massi
 */
public class ControladoraPersistencia {
    HorarioJpaController horaJpa = new HorarioJpaController();
    OdontologoJpaController odontoJpa = new OdontologoJpaController();
    PacienteJpaController pacienJpa = new PacienteJpaController();
    PersonaJpaController personJpa = new PersonaJpaController();
    ResponsableJpaController respoJpa = new ResponsableJpaController();
    SecretarioJpaController secreJpa = new SecretarioJpaController();
    TurnoJpaController turnoJpa = new TurnoJpaController();
    UsuarioJpaController usuJpa = new UsuarioJpaController();

    public void crearUsuario(Usuario usu) {
        usuJpa.create(usu);
    }
}
