package repository.impl;


import model.Director;
import repository.DirectorDAO;
import repository.util.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;


public class DirectorDAOImpl implements DirectorDAO {

    private static EntityManagerFactory managerFactory = EntityUtil.getInstance();


    public boolean addDirectror(Director director) {
        EntityManager entityManager = getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(director);
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

    public boolean remove(int id) {
        EntityManager entityManager = getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete from Director WHERE id=" + id).executeUpdate();
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

    public Director get(int id) {
        EntityManager entityManager = getEntityManager();
        try{
            entityManager.getTransaction().begin();
            Director director = (Director) entityManager.createQuery
                    ("FROM Director WHERE id=" + id).getSingleResult();
            entityManager.getTransaction().commit();
            return director;
        }
        catch (Exception e){
            System.err.println("SOMETHING GO WRONG");
            return null;
        }
        finally {
            entityManager.close();
        }
    }

    public List<Director> getAll() {
        EntityManager entityManager = getEntityManager();
        try{
            return entityManager.createQuery("FROM Director", Director.class).getResultList();
        }
        catch (Exception e){
            System.err.println("SOMETHING GO WRONG");
            return  null;
        }
        finally {
            entityManager.close();
        }
    }

    public boolean update(Director director) {
        EntityManager entityManager = getEntityManager();
        try{
           entityManager.getTransaction().begin();
           entityManager.merge(director);
           entityManager.getTransaction().commit();
           return true;
        }
        catch (Exception e){
            System.err.println("SOMETHING GO WRONG");
            return  false;
        }
        finally {
            entityManager.close();
        }
    }

    public EntityManager getEntityManager(){
        return managerFactory.createEntityManager();
    }
}
