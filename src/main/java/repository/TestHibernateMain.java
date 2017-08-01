package repository;


import model.Drink;
import repository.impl.DrinkDAOImpl;

/**
 * Created by draqo on 30.07.2017.
 */
public class TestHibernateMain {

    public static void main(String[] args) {

        DrinkDAO drink = new DrinkDAOImpl();

        drink.remove(4);


    }
}
