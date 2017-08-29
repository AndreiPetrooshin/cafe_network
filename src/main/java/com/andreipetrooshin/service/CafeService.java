package com.andreipetrooshin.service;

import com.andreipetrooshin.model.Cafe;

import java.util.List;

/**
 * Created by draqo on 15.08.2017.
 */
public interface CafeService {

    Cafe get(int id);

    List<Cafe> getAll();

    boolean remove(int id);

    boolean add(Cafe cafe);

    boolean update(Cafe cafe);

}
