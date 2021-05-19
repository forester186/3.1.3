package com.example.demo.dao;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveUser(User user, String[] roleList) {
        List<Role> roles = new ArrayList<>();
        if(roleList.length == 2){
            user.setRoles(getAllRole());
        } else {
            String str = roleList[0];
            roles.add(getRoleByName(str));
            user.setRoles(roles);
        }
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> getAllRole() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String role) {
        TypedQuery<Role> typedQuery = entityManager.createQuery("select r from Role r where r.role = :role", Role.class);
        typedQuery.setParameter("role", role);
        return typedQuery.getSingleResult();
    }

    @SuppressWarnings("unchecked")
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
    public void updateUser(Long id, User update, String[] roleList) {
        List<Role> roles = new ArrayList<>();
        User user = gerUser(id);
        user = update;
        if(roleList.length == 2){
            user.setRoles(getAllRole());
        } else {
            String str = roleList[0];
            roles.add(getRoleByName(str));
            user.setRoles(roles);
        }
        entityManager.merge(user);
    }

    @Override
    public User getUserByName(String name) {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u where u.name = :name", User.class);
        typedQuery.setParameter("name", name);
        return typedQuery.getSingleResult();

    }
}
