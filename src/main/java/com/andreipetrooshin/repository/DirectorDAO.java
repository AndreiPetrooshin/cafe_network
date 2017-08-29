package com.andreipetrooshin.repository;



import com.andreipetrooshin.model.Director;

import java.util.List;

/**
 * Created by draqo on 29.07.2017.
 */
public interface DirectorDAO {

    boolean addDirector(Director director);

    boolean remove(int id);

    Director get(int id);

    List<Director> getAll();

    boolean update(Director director);

}
