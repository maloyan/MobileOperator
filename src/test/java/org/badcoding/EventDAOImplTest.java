package org.badcoding;

import org.badcoding.hibernate.logic.Factory;
import org.badcoding.hibernate.stored.*;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.Date;
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
/*
    @Test
    public void testRemoveEvent() {
        Event event = Factory.GetInstance().getEventDAO().getEventById(1);
        Contract contract = Factory.GetInstance().getContractDAO().getContractById(4);
        Factory.GetInstance().getContractDAO().removeContract(contract);
        Factory.GetInstance().getEventDAO().removeEvent(event);
        assertNull(event);
    }
*/
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

    @Test
    public void testListEventByDate() {
        Date start = new Date(2000 - 1900, 1, 1);
        Date end = new Date(2018 - 1900, 1, 1);
        List<Event> eventList = Factory.GetInstance().getEventDAO().listEventByDate(start, end);
        assertEquals(eventList.size(), 2);
    }
}