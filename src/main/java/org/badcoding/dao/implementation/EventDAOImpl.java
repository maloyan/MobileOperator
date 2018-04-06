package org.badcoding.dao.implementation;

import org.badcoding.dao.interfaces.EventDAO;
import org.badcoding.hibernate.stored.Event;
import org.badcoding.hibernate.logic.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.hibernate.Query;
import org.hibernate.Session;

@Service
public class EventDAOImpl implements EventDAO {

    public void addEvent(Event event) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.save(event);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateEvent(Event event) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.update(event);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void removeEvent(Event event) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.delete(event);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Event getEventById(int id) {
        Session session = null;
        Event event = null;
        try {
            session = Database.getFactory().openSession();
            event = (Event)session.get(Event.class, id);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return event;
    }

    public List<Event> listEvents() {

        return null;
    }

}
