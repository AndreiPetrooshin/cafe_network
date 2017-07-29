package repository;

import model.Director;

import java.util.List;

public interface DirectorDao {
    boolean create(Director director);

    Director update(Director director);

    boolean remove(int id);

    List<Director> getAll();
}
