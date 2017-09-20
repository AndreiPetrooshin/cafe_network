package com.andreipetrooshin.repository;



import com.andreipetrooshin.model.Drink;

import java.util.List;

/**
 * Created by draqo on 29.07.2017.
 */
public interface DrinkDAO {

    Drink get(int id);

    List<Drink> getAll();

    boolean remove(int id);

    boolean update(Drink drink);

    boolean addDrink(Drink drink);

    List<Drink> getByCafeId(int id);





}
