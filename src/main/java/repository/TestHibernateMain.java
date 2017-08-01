package repository;


import model.Drink;
import repository.impl.CafeDAOImpl;
import repository.impl.DirectorDAOImpl;
import repository.impl.DrinkDAOImpl;

/**
 * Created by draqo on 30.07.2017.
 */
public class TestHibernateMain {

    public static void main(String[] args) {
            DrinkDAO drinkDAO = new DrinkDAOImpl();
            DirectorDAO directorDAO = new DirectorDAOImpl();
        CafeDAOImpl cafeDAO = new CafeDAOImpl();
//        Cafe cafe = new Cafe("yl. Lenina 20", "Show Cafe", directorDAO.get(1),5.0);
//        cafeDAO.addCafe(cafe);
        Drink drink = new Drink("kopuchino", 19.99, 350, cafeDAO.getCafe(1));
        System.out.println(drink);
        drinkDAO.addDrink(drink);



    }
}
