package com.andreipetrooshin.service.impl;

import com.andreipetrooshin.model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andreipetrooshin.repository.DrinkDAO;
import com.andreipetrooshin.service.DrinkService;

import java.util.Comparator;
import java.util.List;

/**
 * Created by draqo on 15.08.2017.
 */
@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    private DrinkDAO dao;


    @Override
    public Drink get(int id) {
        return dao.get(id);
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
    public List<Drink> getByCafeId(int id) {
        return dao.getByCafeId(id);
    }


    @Override
    public List<Drink> sortByPrice() {
        List<Drink> drinks = getAll();
        drinks.sort((o1, o2) -> o1.getPrice() < o2.getPrice() ? 1 : o1.getPrice() > o2.getPrice() ? -1 : 0);
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
