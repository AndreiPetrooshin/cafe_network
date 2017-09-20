package com.andreipetrooshin.service;

import com.andreipetrooshin.model.Cafe;

import java.util.List;


public interface CafeService {

    Cafe get(int id);

    List<Cafe> getAll();

    boolean remove(int id);

    boolean add(Cafe cafe);

    boolean update(Cafe cafe);

}
