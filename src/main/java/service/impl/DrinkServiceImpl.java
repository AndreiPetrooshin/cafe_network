package service.impl;

import model.Drink;
import repository.DrinkDAO;
import repository.impl.DrinkDAOImpl;
import service.DrinkService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by draqo on 15.08.2017.
 */
public class DrinkServiceImpl implements DrinkService {

    private static DrinkDAO dao =  new DrinkDAOImpl();

    @Override
    public Drink get(int id) {
        return dao.getDrink(id);
    }

    @Override
    public List<Drink> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean remove(int id) {
        return dao.remove(id);
    }

    @Override
    public boolean add(Drink drink) {
        return dao.addDrink(drink);
    }

    @Override
    public boolean update(Drink drink) {
        return dao.update(drink);
    }


    @Override
    public List<Drink> sortByPrice(){
        List<Drink> drinks = getAll();
        drinks.sort((o1, o2) -> o1.getPrice() < o2.getPrice() ? 1 : o1.getPrice() > o2.getPrice()?-1:0);
        System.out.println(drinks);
        return drinks;
    }


    @Override
    public List<Drink> sortByAlphabet() {
        List<Drink> drinks = getAll();
        drinks.sort(Comparator.comparing(Drink::getName));
        System.out.println(drinks);
        return drinks;
    }

}
