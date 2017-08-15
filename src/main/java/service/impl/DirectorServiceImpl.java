package service.impl;

import model.Director;
import repository.DirectorDAO;
import repository.impl.DirectorDAOImpl;
import service.DirectorService;

import java.util.List;

/**
 * Created by draqo on 15.08.2017.
 */
public class DirectorServiceImpl implements DirectorService {

    private static DirectorDAO dao = new DirectorDAOImpl();

    @Override
    public Director get(int id) {
        return dao.get(id);
    }

    @Override
    public List<Director> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean remove(int id) {
        return dao.remove(id);
    }

    @Override
    public boolean add(Director director) {
        return dao.addDirectror(director);
    }

    @Override
    public boolean update(Director director) {
        return dao.update(director);
    }
}
