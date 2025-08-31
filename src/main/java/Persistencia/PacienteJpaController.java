/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Paciente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Responsable;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author massi
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public PacienteJpaController(){
        emf=Persistence.createEntityManagerFactory("ClinicaOdontologicoPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Responsable anResponsable = paciente.getAnResponsable();
            if (anResponsable != null) {
                anResponsable = em.getReference(anResponsable.getClass(), anResponsable.getId());
                paciente.setAnResponsable(anResponsable);
            }
            em.persist(paciente);
            if (anResponsable != null) {
                Paciente oldAnPacienteOfAnResponsable = anResponsable.getAnPaciente();
                if (oldAnPacienteOfAnResponsable != null) {
                    oldAnPacienteOfAnResponsable.setAnResponsable(null);
                    oldAnPacienteOfAnResponsable = em.merge(oldAnPacienteOfAnResponsable);
                }
                anResponsable.setAnPaciente(paciente);
                anResponsable = em.merge(anResponsable);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getId());
            Responsable anResponsableOld = persistentPaciente.getAnResponsable();
            Responsable anResponsableNew = paciente.getAnResponsable();
            if (anResponsableNew != null) {
                anResponsableNew = em.getReference(anResponsableNew.getClass(), anResponsableNew.getId());
                paciente.setAnResponsable(anResponsableNew);
            }
            paciente = em.merge(paciente);
            if (anResponsableOld != null && !anResponsableOld.equals(anResponsableNew)) {
                anResponsableOld.setAnPaciente(null);
                anResponsableOld = em.merge(anResponsableOld);
            }
            if (anResponsableNew != null && !anResponsableNew.equals(anResponsableOld)) {
                Paciente oldAnPacienteOfAnResponsable = anResponsableNew.getAnPaciente();
                if (oldAnPacienteOfAnResponsable != null) {
                    oldAnPacienteOfAnResponsable.setAnResponsable(null);
                    oldAnPacienteOfAnResponsable = em.merge(oldAnPacienteOfAnResponsable);
                }
                anResponsableNew.setAnPaciente(paciente);
                anResponsableNew = em.merge(anResponsableNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paciente.getId();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            Responsable anResponsable = paciente.getAnResponsable();
            if (anResponsable != null) {
                anResponsable.setAnPaciente(null);
                anResponsable = em.merge(anResponsable);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Paciente findPaciente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
