package repository.impl;

import model.Cafe;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.CafeDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class CafeDAOImpl implements CafeDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Cafe get(int id) {
        try {
            return (Cafe) entityManager.createQuery("FROM Cafe WHERE id=" + id).getSingleResult();
        } catch (Exception e) {
            System.err.println("SOMETHING GO WRONG");
            return null;
        } finally {
            entityManager.close();
        }
    }

    public List<Cafe> getAll() {
        try {
            return entityManager.createQuery("FROM Cafe", Cafe.class).getResultList();
        } catch (Exception e) {
            System.err.println("SOMETHING GO WRONG");
            return null;
        } finally {
            entityManager.close();
        }

    }

    public boolean remove(int id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM Cafe WHERE id=" + id).executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println("SOMETHING GO WRONG");
            return false;
        } finally {
            entityManager.close();
        }

    }

    public boolean addCafe(Cafe cafe) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cafe);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println("SOMETHING GO WRONG WITH ADD CAFE");
            return false;
        } finally {
            entityManager.close();
        }

    }

    public boolean updateCafe(Cafe cafe) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cafe);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println("SOMETHING GO WRONG WITH UPDATE");
            return false;
        } finally {
            entityManager.close();
        }

    }


}
