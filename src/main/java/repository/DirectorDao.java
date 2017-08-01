package repository;



import model.Director;

import java.util.List;

/**
 * Created by draqo on 29.07.2017.
 */
public interface DirectorDAO {

    boolean addDirectror(Director director);

    boolean remove(int id);

    Director get(int id);

    List getAll();

    boolean update(Director director);

}
