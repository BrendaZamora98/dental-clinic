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
import logic.Guardian;
import persistence.exceptions.NonexistentEntityException;

public class GuardianJpaController implements Serializable {

    public GuardianJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public GuardianJpaController() {
        emf = Persistence.createEntityManagerFactory("DentalClinicPU");
    }

    public void create(Guardian guardian) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(guardian);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Guardian guardian) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            guardian = em.merge(guardian);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = guardian.getPersonId();
                if (findGuardian(id) == null) {
                    throw new NonexistentEntityException("The guardian with id " + id + " no longer exists.");
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
            Guardian guardian;
            try {
                guardian = em.getReference(Guardian.class, id);
                guardian.getPersonId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The guardian with id " + id + " no longer exists.", enfe);
            }
            em.remove(guardian);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Guardian> findGuardianEntities() {
        return findGuardianEntities(true, -1, -1);
    }

    public List<Guardian> findGuardianEntities(int maxResults, int firstResult) {
        return findGuardianEntities(false, maxResults, firstResult);
    }

    private List<Guardian> findGuardianEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Guardian.class));
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

    public Guardian findGuardian(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Guardian.class, id);
        } finally {
            em.close();
        }
    }

    public int getGuardianCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Guardian> rt = cq.from(Guardian.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
