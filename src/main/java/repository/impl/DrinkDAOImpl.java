package repository.impl;


import model.Drink;
import repository.DrinkDAO;
import repository.util.EntityUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

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

    public List<Drink> getAll() {
        EntityManager entityManager = getEntityManager();
        try{
            return entityManager.createQuery("FROM Drink", Drink.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("SOMETHING GO WRONG AT GET ALL METHOD");
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
        EntityManager entityManager = getEntityManager();
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
        EntityManager entityManager = getEntityManager();
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

    public EntityManager getEntityManager(){
        return managerFactory.createEntityManager();
    }

}
