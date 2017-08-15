package service.impl;

import model.Cafe;
import repository.CafeDAO;
import repository.impl.CafeDAOImpl;
import service.CafeService;

import java.util.List;

/**
 * Created by draqo on 15.08.2017.
 */
public class CafeServiceImpl implements CafeService {

    private static CafeDAO dao = new CafeDAOImpl();

    @Override
    public Cafe get(int id) {
        return dao.getCafe(id);
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
