package com.mrhu.ssh.dao.impl;

import com.mrhu.ssh.dao.UserDao;
import com.mrhu.ssh.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public boolean exist(User user) {
        Session session = sessionFactory.getCurrentSession();
        List<User> list = (List<User>) session.createQuery("from User user where user.username = :name")
            .setParameter("name", user.getUsername())
            .list();
        if(list.size() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
