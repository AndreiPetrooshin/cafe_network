package repository.impl;



import model.Drink;
import repository.DrinkDAO;
import repository.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by draqo on 30.07.2017.
 */
public class DrinkDAOImpl implements DrinkDAO {

    private static EntityManagerFactory managerFactory = EntityUtil.getInstance();


    public Drink getDrink(int id) {
        EntityManager entityManager = getEntityManager();
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

    public List getAll() {
        EntityManager entityManager = getEntityManager();
        try{
            return entityManager.createQuery("FROM Drink").getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("SOMETHING GO WRONG AT GET ALL METHOD");
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
            entityManager.createQuery("delete FROM Drink WHERE id=" + id);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("SOMETHING GO WRONG AT REMOVE METHOD");
            return false;
        }
        finally {
            entityManager.close();
        }

    }

    public boolean update(Drink drink) {
        EntityManager entityManager = getEntityManager();
        try{
            entityManager.getTransaction().begin();
            Drink drinkFromDB = entityManager.find(Drink.class, drink.getId());
            drinkFromDB.setName(drink.getName());
            drinkFromDB.setCafe(drink.getCafe());
            drinkFromDB.setCapacity(drink.getCapacity());
            drinkFromDB.setPrice(drink.getPrice());
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("SOMETHING GO WRONG AT UPDATE METHOD");
            return false;
        }
        finally {
            entityManager.close();
        }

    }

    public boolean addDrink(Drink drink) {
        EntityManager entityManager = getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(drink);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("SOMETHING GO WRONG AT ADD METHOD");
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
