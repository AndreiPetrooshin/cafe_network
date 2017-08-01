package repository;



import model.Cafe;

import java.util.List;

/**
 * Created by draqo on 29.07.2017.
 */
public interface  CafeDAO {

    Cafe getCafe(int id);

    List getAll();

    boolean remove(int id);

    boolean addCafe(Cafe cafe);

    boolean updateCafe(Cafe cafe);



}
