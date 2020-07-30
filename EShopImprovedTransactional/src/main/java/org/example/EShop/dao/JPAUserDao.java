package org.example.EShop.dao;

import org.example.EShop.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Component
public class JPAUserDao {

    private static final Logger LOG = Logger.getLogger(JPAUserDao.class);

    @PersistenceContext
    private EntityManager manager;

    public JPAUserDao() {
    }

    @Transactional
    public User create(User user) {
        manager.persist(user);
        return user;
    }

    @Transactional
    public User find(int id) {
        User found = manager.find(User.class, id);
        return found;
    }

    @Transactional
    public User find(String email) {
        TypedQuery<User> typedQuery =
                manager.createQuery("Select u FROM User u WHERE u.email = :email", User.class);
        User user = typedQuery.setParameter("email", email).getSingleResult();
        return user;
    }

    public List<User> findAll() {
        TypedQuery<User> typedQuery = manager.createQuery("Select u FROM User u", User.class);
        return typedQuery.getResultList();
    }

    @Transactional
    public User update(User user) {
        User found = manager.find(User.class, user.getId());
        found.setUserType(user.getUserType());
        found.setEmail(user.getEmail());
        found.setFullname(user.getFullname());
        found.setPass(user.getPass());
        found.setPhone(user.getPhone());
        manager.merge(found);
        return found;
    }

    @Transactional
    public boolean delete(User user) {
        User found = manager.find(User.class, user.getId());
        manager.remove(found);
        return true;
    }
}
