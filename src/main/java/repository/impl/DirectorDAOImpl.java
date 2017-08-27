package repository.impl;


import model.Director;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.DirectorDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DirectorDAOImpl implements DirectorDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean addDirector(Director director) {
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
}
