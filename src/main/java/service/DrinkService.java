package service;

import model.Drink;

import java.util.List;

/**
 * Created by draqo on 15.08.2017.
 */
public interface DrinkService {

    Drink get(int id);

    List<Drink> getAll();

    boolean remove(int id);

    boolean add(Drink drink);

    boolean update(Drink drink);

    List<Drink> sortByPrice();

    List<Drink> sortByAlphabet();
}
