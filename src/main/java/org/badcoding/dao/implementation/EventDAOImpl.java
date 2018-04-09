package org.badcoding.dao.implementation;

import org.badcoding.dao.interfaces.EventDAO;
import org.badcoding.hibernate.stored.Event;
import org.badcoding.hibernate.logic.Database;

import java.sql.Timestamp;
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

    public List<Event> listEventByDate(Date start, Date end) {
        Session session = null;
        List<Event> eventList = new ArrayList<Event>();
        try {
            String queryText =
                    "SELECT f " +
                    "FROM Event f " +
                    "WHERE f.startDate > :start AND f.startDate < :end";
            session = Database.getFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(queryText);
            if (start != null)
                query.setDate("start", start);
            if (end != null)
                query.setDate("end", end);
            eventList = query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return eventList;

    }

    public List<Event> listEvents() {
        Session session = null;
        List<Event> eventList = new ArrayList<Event>();
        try {
            String queryText =
                    "SELECT f " +
                     "FROM Event f ";
            session = Database.getFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(queryText);
            eventList = query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return eventList;
    }

}
