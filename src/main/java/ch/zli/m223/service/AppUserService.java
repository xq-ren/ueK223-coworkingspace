package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.AppUser;

@ApplicationScoped
public class AppUserService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public AppUser createUser(AppUser user) {
        entityManager.persist(user);
        return user;
    }

    public List<AppUser> findAll() {
        var query = entityManager.createQuery("FROM Entry", AppUser.class);
        return query.getResultList();
    }
}