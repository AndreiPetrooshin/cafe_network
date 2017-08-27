package service.impl;

import model.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DirectorDAO;
import service.DirectorService;

import java.util.List;

/**
 * Created by draqo on 15.08.2017.
 */
@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorDAO dao;

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
        return dao.addDirector(director);
    }

    @Override
    public boolean update(Director director) {
        return dao.update(director);
    }
}
