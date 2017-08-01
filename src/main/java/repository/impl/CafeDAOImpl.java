package repository.impl;



import model.Cafe;
import repository.CafeDAO;
import repository.EntityUtil;

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

    public List getAll() {
        EntityManager entityManager = getEntityManager();
        try{
           return entityManager.createQuery("FROM Cafe ").getResultList();
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
            Cafe cafeFromBd = entityManager.find(Cafe.class, cafe.getId());
            cafeFromBd.setName(cafe.getName());
            cafeFromBd.setAddress(cafe.getAddress());
            cafeFromBd.setDirector(cafe.getDirector());
            cafeFromBd.setDrinkList(cafe.getDrinkList());
            cafeFromBd.setRating(cafe.getRating());
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
