package com.example.demo.dao;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public User save(User user){
        entityManager.persist(user);
        return user;
    }

    @Override
    public List<Role> getAllRole() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String role) {
        TypedQuery<Role> typedQuery = entityManager.createQuery("select r from Role r where r.role = :role", Role.class);
        typedQuery.setParameter("role", role);
        return typedQuery.getSingleResult();
    }

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User gerUser(Long id) {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void deleteUser(Long id) {
        User user = gerUser(id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserByName(String name) {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u where u.name = :name", User.class);
        typedQuery.setParameter("name", name);
        return typedQuery.getSingleResult();

    }
}
