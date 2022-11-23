package ch.zli.m223.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<AppUser> findByUsername(String string) {
        return entityManager
                .createNamedQuery("AppUser.findByUsername", AppUser.class)
                .setParameter("username", string)
                .getResultStream()
                .findFirst();
    }

    public Optional<AppUser> findByUserSince(LocalDateTime userSince) {
        return entityManager
                .createNamedQuery("AppUser.findByUserSince", AppUser.class)
                .setParameter("userSince", userSince)
                .getResultStream()
                .findFirst();
    }

    public void deleteUser(Long id) {
        var entity = entityManager.find(AppUser.class, id);
        entityManager.remove(entity);
    }

    public AppUser updateUser(Long id, AppUser user) {
        user.setId(id);
        return entityManager.merge(user);
    }
}
