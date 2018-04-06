package org.badcoding.dao.implementation;

import org.badcoding.dao.interfaces.ServiceDAO;
import org.badcoding.hibernate.stored.Services;
import org.badcoding.hibernate.logic.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.hibernate.Query;
import org.hibernate.Session;

@Service
public class ServiceDAOImpl implements ServiceDAO {

    public void addService(Services service) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.save(service);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateService(Services service) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.update(service);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void removeService(Services service) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.delete(service);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Services getServiceById(int id) {
        Session session = null;
        Services service = null;
        try {
            session = Database.getFactory().openSession();
            service = (Services)session.get(Services.class, id);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return service;
    }

    public List<Services> listServices() {

        return null;
    }

}
