package org.badcoding.dao.interfaces;

import org.badcoding.hibernate.stored.Event;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface EventDAO {
    void addEvent(Event event);

    void updateEvent(Event event);

    void removeEvent(Event event);

    Event getEventById(int id);

    List<Event> listEventByDate(Date start, Date end);

    List<Event> listEvents();
}
