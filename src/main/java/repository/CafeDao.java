package repository;

import model.Cafe;

import java.util.List;

public interface CafeDao {
    boolean create(Cafe cafe);

    boolean remove(int id);

    Cafe update(Cafe cafe);

    List<Cafe> getAll();
}
