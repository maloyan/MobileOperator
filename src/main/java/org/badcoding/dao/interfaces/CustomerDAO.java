package org.badcoding.dao.interfaces;

import org.badcoding.hibernate.stored.Customer;

import java.util.List;

public interface CustomerDAO {
    void addCustomer(Customer Customer);

    void updateCustomer(Customer Customer);

    void removeCustomer(Customer Customer);

    Customer getCustomerById(int id);

    List<Customer> listCustomers();
}
