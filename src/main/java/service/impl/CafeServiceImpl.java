package service.impl;

import model.Cafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CafeDAO;
import service.CafeService;

import java.util.List;

/**
 * Created by draqo on 15.08.2017.
 */
@Service
public class CafeServiceImpl implements CafeService {

    @Autowired
    private CafeDAO dao;

    @Override
    public Cafe get(int id) {
        return dao.get(id);
    }

    @Override
    public List<Cafe> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean remove(int id) {
        return dao.remove(id);
    }

    @Override
    public boolean add(Cafe cafe) {
        return dao.addCafe(cafe);
    }

    @Override
    public boolean update(Cafe cafe) {
        return dao.updateCafe(cafe);
    }
}
