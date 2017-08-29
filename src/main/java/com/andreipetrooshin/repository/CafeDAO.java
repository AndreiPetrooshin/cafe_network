package com.andreipetrooshin.repository;



import com.andreipetrooshin.model.Cafe;

import java.util.List;

/**
 * Created by draqo on 29.07.2017.
 */
public interface  CafeDAO {

    Cafe get(int id);

    List<Cafe> getAll();

    boolean remove(int id);

    boolean addCafe(Cafe cafe);

    boolean updateCafe(Cafe cafe);



}
