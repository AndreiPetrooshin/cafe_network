package com.andreipetrooshin.repository.impl;


import com.andreipetrooshin.model.Director;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.andreipetrooshin.repository.DirectorDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DirectorDAOImpl implements DirectorDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public boolean addDirector(Director director) {
        entityManager.persist(director);
        return true;
    }

    @Transactional
    public boolean remove(int id) {
        entityManager.createQuery("delete from Director WHERE id=" + id).executeUpdate();
        return true;
    }

    public Director get(int id) {
        return entityManager.find(Director.class, id);
    }


    @Cacheable("directorCache")
    public List<Director> getAll() {
        return entityManager.createQuery("FROM Director", Director.class).getResultList();
    }

    @Transactional
    public boolean update(Director director) {
        entityManager.merge(director);
        return true;
    }
}
