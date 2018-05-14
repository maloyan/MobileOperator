package org.badcoding.dao.implementation;

import org.badcoding.dao.interfaces.CustomerDAO;
import org.badcoding.hibernate.stored.Contract;
import org.badcoding.hibernate.stored.Customer;
import org.badcoding.hibernate.logic.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.hibernate.Query;
import org.hibernate.Session;

@Service
public class CustomerDAOImpl implements CustomerDAO {

    public void addCustomer(Customer customer) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateCustomer(Customer customer) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void removeCustomer(Customer customer) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Customer getCustomerById(int id) {
        Session session = null;
        Customer customer = null;
        try {
            session = Database.getFactory().openSession();
            customer = (Customer)session.get(Customer.class, id);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customer;
    }

    public List<Customer> listCustomers() {
        Session session = null;
        List<Customer> customersList = new ArrayList<Customer>();
        try {
            String queryText =
                    "SELECT f " +
                            "FROM Customer f ";
            session = Database.getFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(queryText);
            customersList = query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customersList;
    }
    public List<Customer> listCustomersByName(String first_name, String last_name) {
        Session session = null;
        List<Customer> customersList = new ArrayList<Customer>();
        try {
            String queryText =
                    "SELECT c " +
                            "FROM Customer c ";
            if (first_name != null)
                queryText += "WHERE c.firstName = :first_name";
            if (last_name != null)
                queryText += " AND c.lastName = :last_name";
            session = Database.getFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(queryText);
            if (first_name != null)
                query.setString("first_name", first_name);
            if (last_name != null)
                query.setString("last_name", last_name);
            customersList = query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customersList;
    }
}
