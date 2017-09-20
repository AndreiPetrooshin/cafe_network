package com.andreipetrooshin.repository.impl;


import com.andreipetrooshin.model.Drink;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.andreipetrooshin.repository.DrinkDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DrinkDAOImpl implements DrinkDAO {


    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Drink get(int id) {
           return entityManager.find(Drink.class, id);
    }

    @Cacheable("drinkCache")
    public List<Drink> getAll() {
        return entityManager.createQuery("FROM Drink", Drink.class).getResultList();
    }

    @Transactional
    public boolean remove(int id) {
            entityManager.createQuery("delete FROM Drink WHERE id=" + id).executeUpdate();
            return true;
    }

    @Transactional
    public boolean update(Drink drink) {
            entityManager.merge(drink);
            return true;
    }

    @Transactional
    public boolean addDrink(Drink drink) {
        entityManager.persist(drink);
        return true;
    }

    @Override
    public List<Drink> getByCafeId(int id) {
        return  entityManager.createNamedQuery(Drink.GET_BY_CAFE_ID, Drink.class)
                .setParameter("id", id).getResultList();
    }
}
