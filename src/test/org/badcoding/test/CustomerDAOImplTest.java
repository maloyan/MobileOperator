package org.badcoding.test;

import org.badcoding.hibernate.logic.Factory;
import org.badcoding.hibernate.stored.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerDAOImplTest {

    @Test
    public void testAddCustomer() {
        Customer customer = Factory.GetInstance().getCustomerDAO().getCustomerById(2);
        Customer customer1 = customer;
        customer1.setCustomerId(10);
        List<Customer> customerList = Factory.GetInstance().getCustomerDAO().listCustomers();
        Factory.GetInstance().getCustomerDAO().addCustomer(customer1);
        List<Customer> newCustomerList = Factory.GetInstance().getCustomerDAO().listCustomers();
        assertEquals(customerList.size() + 1, newCustomerList.size());
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = Factory.GetInstance().getCustomerDAO().getCustomerById(2);
        customer.setLastName("Memos");
        Factory.GetInstance().getCustomerDAO().updateCustomer(customer);
        assertEquals(customer.getLastName(), "Memos");
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = Factory.GetInstance().getCustomerDAO().getCustomerById(4);
        assertEquals(customer.getCustomerId(), 4);
    }



}