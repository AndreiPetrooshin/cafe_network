package repository;



import model.Drink;

import java.util.List;

/**
 * Created by draqo on 29.07.2017.
 */
public interface DrinkDAO {

    Drink getDrink(int id);

    List getAll();

    boolean remove(int id);

    boolean update(Drink drink);

    boolean addDrink(Drink drink);





}
