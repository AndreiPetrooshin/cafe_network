package repository.impl;


import model.Drink;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.DrinkDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DrinkDAOImpl implements DrinkDAO {


    private EntityManager entityManager;

    @PersistenceContext(unitName = "persUnit")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Drink get(int id) {
        try{
           return entityManager.find(Drink.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("SOMETHING GO WRONG AT GET METHOD");
            return null;
        }
        finally {
            entityManager.close();
        }
    }

    public List<Drink> getAll() {
            return entityManager.createQuery("FROM Drink", Drink.class).getResultList();
    }

    public boolean remove(int id) {
        try{
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete FROM Drink WHERE id=" + id).executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("SOMETHING GO WRONG AT REMOVE METHOD");
            return false;
        }
        finally {
            entityManager.close();
        }

    }

    public boolean update(Drink drink) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(drink);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("SOMETHING GO WRONG AT UPDATE METHOD");
            return false;
        }
        finally {
            entityManager.close();
        }

    }

    public boolean addDrink(Drink drink) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(drink);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("SOMETHING GO WRONG AT ADD METHOD");
            return false;
        }
        finally {
            entityManager.close();
        }

    }
}
