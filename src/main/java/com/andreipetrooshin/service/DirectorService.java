package com.andreipetrooshin.service;

import com.andreipetrooshin.model.Director;

import java.util.List;



public interface DirectorService {

    Director get(int id);

    List<Director> getAll();

    boolean remove(int id);

    boolean add(Director director);

    boolean update(Director director);
}
