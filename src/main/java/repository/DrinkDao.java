package repository;

import model.Drink;

import java.util.List;

public interface DrinkDao {
    boolean create(Drink drink);
    Drink update(Drink drink);
    boolean remove(int id);
    List<Drink> getAll();
}
