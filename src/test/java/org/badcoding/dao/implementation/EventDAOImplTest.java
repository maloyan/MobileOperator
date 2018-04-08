package org.badcoding.dao.implementation;

import org.badcoding.hibernate.logic.Factory;
import org.badcoding.hibernate.stored.Event;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class EventDAOImplTest {

    @Test
    public void testAddEvent() {
        Event event = Factory.GetInstance().getEventDAO().getEventById(1);
        Event event1 = event;
        event1.setEventId(12);
        Factory.GetInstance().getEventDAO().addEvent(event1);
        assertEquals(Factory.GetInstance().getEventDAO().getEventById(1).getAmount(), 100);
    }

    @Test
    public void testUpdateEvent() {
        Event event = Factory.GetInstance().getEventDAO().getEventById(1);
        event.setAmount(10);
        Factory.GetInstance().getEventDAO().updateEvent(event);
        assertEquals(event.getAmount(), 10);
    }

    @Test
    public void testGetEventById() {
        Event event = Factory.GetInstance().getEventDAO().getEventById(1);
        assertEquals(event.getEventId(), 1);
    }

    @Test
    public void testListEvents() {
        List<Event> eventList = Factory.GetInstance().getEventDAO().listEvents();
        Event event = Factory.GetInstance().getEventDAO().getEventById(1);
        event.setEventId(13);
        Factory.GetInstance().getEventDAO().addEvent(event);
        List<Event> newEventList = Factory.GetInstance().getEventDAO().listEvents();
        assertEquals(eventList.size() + 1, newEventList.size());
    }
}