package org.badcoding.dao.implementation;

import org.badcoding.dao.interfaces.UserDAO;
import org.badcoding.hibernate.stored.User;
import org.badcoding.hibernate.logic.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.badcoding.hibernate.stored.Customer;
import org.springframework.stereotype.Service;
import org.hibernate.Query;
import org.hibernate.Session;

@Service
public class UserDAOImpl implements UserDAO {

    public void addUser(User contract) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.save(contract);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateUser(User contract) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.update(contract);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void removeUser(User contract) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.delete(contract);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public User getUserById(int id) {
        Session session = null;
        User contract = null;
        try {
            session = Database.getFactory().openSession();
            contract = (User)session.get(User.class, id);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contract;
    }

    public List<User> listUsers() {
        Session session = null;
        List<User> contractList = new ArrayList<User>();
        try {
            String queryText =
                    "SELECT f " +
                    "FROM User f ";
            session = Database.getFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(queryText);
            contractList = query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contractList;
    }

}