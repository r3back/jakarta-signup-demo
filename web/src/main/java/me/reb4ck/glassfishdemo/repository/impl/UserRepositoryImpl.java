package me.reb4ck.glassfishdemo.repository.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import me.reb4ck.glassfishdemo.entity.UserEntity;
import me.reb4ck.glassfishdemo.repository.UserRepository;

@ApplicationScoped
@Slf4j
public final class UserRepositoryImpl implements UserRepository {
    /*@PersistenceUnit(unitName= "default")
    private EntityManagerFactory entityManagerFactory;*/

    @Override
    public void saveEntity(UserEntity entity) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
