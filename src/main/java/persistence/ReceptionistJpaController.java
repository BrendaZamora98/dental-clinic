package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import logic.Receptionist;
import persistence.exceptions.NonexistentEntityException;

public class ReceptionistJpaController implements Serializable {

    public ReceptionistJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ReceptionistJpaController() {
        emf = Persistence.createEntityManagerFactory("DentalClinicPU");
    }

    public void create(Receptionist receptionist) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(receptionist);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Receptionist receptionist) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            receptionist = em.merge(receptionist);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = receptionist.getPersonId();
                if (findReceptionist(id) == null) {
                    throw new NonexistentEntityException("The receptionist with id " + id + " no longer exists.");
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
            Receptionist receptionist;
            try {
                receptionist = em.getReference(Receptionist.class, id);
                receptionist.getPersonId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The receptionist with id " + id + " no longer exists.", enfe);
            }
            em.remove(receptionist);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Receptionist> findReceptionistEntities() {
        return findReceptionistEntities(true, -1, -1);
    }

    public List<Receptionist> findReceptionistEntities(int maxResults, int firstResult) {
        return findReceptionistEntities(false, maxResults, firstResult);
    }

    private List<Receptionist> findReceptionistEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Receptionist.class));
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

    public Receptionist findReceptionist(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Receptionist.class, id);
        } finally {
            em.close();
        }
    }

    public int getReceptionistCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Receptionist> rt = cq.from(Receptionist.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
