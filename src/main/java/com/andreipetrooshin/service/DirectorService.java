package com.andreipetrooshin.service;

import com.andreipetrooshin.model.Director;

import java.util.List;

/**
 * Created by draqo on 15.08.2017.
 */
public interface DirectorService {

    Director get(int id);

    List<Director> getAll();

    boolean remove(int id);

    boolean add(Director director);

    boolean update(Director director);
}
