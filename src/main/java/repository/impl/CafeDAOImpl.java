package repository.impl;

import model.Cafe;
import repository.CafeDAO;
import repository.util.EntityUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class CafeDAOImpl implements CafeDAO {

    private static EntityManagerFactory managerFactory = EntityUtil.getInstance();




    public Cafe getCafe(int id) {
       EntityManager entityManager = getEntityManager();
       try{
          return (Cafe) entityManager.createQuery("FROM Cafe WHERE id=" + id).getSingleResult();
       }
       catch (Exception e){
           System.err.println("SOMETHING GO WRONG");
           return null;
       }
       finally {
           entityManager.close();
       }
    }

    public List<Cafe> getAll() {
        EntityManager entityManager = getEntityManager();
        try{
           return entityManager.createQuery("FROM Cafe", Cafe.class).getResultList();
        }
        catch (Exception e){
            System.err.println("SOMETHING GO WRONG");
            return null;
        }
        finally {
            entityManager.close();
        }

    }

    public boolean remove(int id) {
        EntityManager entityManager = getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM Cafe WHERE id=" + id).executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            System.err.println("SOMETHING GO WRONG");
            return false;
        }
        finally {
            entityManager.close();
        }

    }

    public boolean addCafe(Cafe cafe) {
        EntityManager entityManager = getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(cafe);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            System.err.println("SOMETHING GO WRONG WITH ADD CAFE");
            return  false;
        }
        finally {
            entityManager.close();
        }

    }

    public boolean updateCafe(Cafe cafe) {
        EntityManager entityManager = getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(cafe);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            System.err.println("SOMETHING GO WRONG WITH UPDATE");
            return false;
        }
        finally {
            entityManager.close();
        }

    }

    public EntityManager getEntityManager(){
        return managerFactory.createEntityManager();
    }

}
