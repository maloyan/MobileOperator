package org.badcoding.dao.interfaces;

import org.badcoding.hibernate.stored.Customer;

import java.util.List;

public interface CustomerDAO {
    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void removeCustomer(Customer customer);

    Customer getCustomerById(int id);

    List<Customer> listCustomers();
}
