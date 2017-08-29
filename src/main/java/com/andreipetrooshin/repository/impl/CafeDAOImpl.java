package com.andreipetrooshin.repository.impl;

import com.andreipetrooshin.model.Cafe;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.andreipetrooshin.repository.CafeDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class CafeDAOImpl implements CafeDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Cafe get(int id) {
            return entityManager.find(Cafe.class, id);

    }

    public List<Cafe> getAll() {
            return entityManager.createQuery("FROM Cafe", Cafe.class).getResultList();
    }

    @Transactional
    public boolean remove(int id) {
            entityManager.createQuery("DELETE FROM Cafe WHERE id=" + id).executeUpdate();
            return true;

    }

    @Transactional
    public boolean addCafe(Cafe cafe) {
            entityManager.persist(cafe);
            return true;
    }

    @Transactional
    public boolean updateCafe(Cafe cafe) {
            entityManager.merge(cafe);
            return true;
    }


}
