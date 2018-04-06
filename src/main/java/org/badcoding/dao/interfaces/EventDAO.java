package org.badcoding.dao.interfaces;

import org.badcoding.hibernate.stored.Event;

import java.util.List;

public interface EventDAO {
    void addEvent(Event Event);

    void updateEvent(Event Event);

    void removeEvent(Event Event);

    Event getEventById(int id);

    List<Event> listEvents();
}
