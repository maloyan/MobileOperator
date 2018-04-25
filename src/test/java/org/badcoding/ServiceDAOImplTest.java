package org.badcoding;

import org.badcoding.hibernate.logic.Factory;
import org.badcoding.hibernate.stored.*;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.List;


public class ServiceDAOImplTest {

    @Test
    public void testAddService() {
        Services service = Factory.GetInstance().getServiceDAO().getServiceById(1);
        Services service1 = service;
        service1.setServiceId(10);
        Factory.GetInstance().getServiceDAO().addService(service1);
        assertEquals(service1.getServiceName(), service.getServiceName());
    }

    @Test
    public void testUpdateService() {
        Services service = Factory.GetInstance().getServiceDAO().getServiceById(1);
        service.setServiceName("New service");
        Factory.GetInstance().getServiceDAO().updateService(service);
        assertEquals(service.getServiceName(), "New service");
    }

    @Test
    public void testGetServiceById() {
        Services service = Factory.GetInstance().getServiceDAO().getServiceById(1);
        assertEquals(service.getServiceId(), 1);
    }

    @Test
    public void testListServices() {
        List<Services> serviceList = Factory.GetInstance().getServiceDAO().listServices();
        Services service = Factory.GetInstance().getServiceDAO().getServiceById(1);
        service.setServiceId(22);
        Factory.GetInstance().getServiceDAO().addService(service);
        List<Services> newServicesList = Factory.GetInstance().getServiceDAO().listServices();
        assertEquals(serviceList.size() + 1, newServicesList.size());
    }
}