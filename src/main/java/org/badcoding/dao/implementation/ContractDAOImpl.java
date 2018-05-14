package org.badcoding.dao.implementation;

import org.badcoding.dao.interfaces.ContractDAO;
import org.badcoding.hibernate.stored.Contract;
import org.badcoding.hibernate.logic.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.badcoding.hibernate.stored.Customer;
import org.springframework.stereotype.Service;
import org.hibernate.Query;
import org.hibernate.Session;

@Service
public class ContractDAOImpl implements ContractDAO {

    public void addContract(Contract contract) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.save(contract);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateContract(Contract contract) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.update(contract);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void removeContract(Contract contract) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.delete(contract);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Contract getContractById(int id) {
        Session session = null;
        Contract contract = null;
        try {
            session = Database.getFactory().openSession();
            contract = (Contract)session.get(Contract.class, id);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contract;
    }

    public List<Contract> listContracts() {
        Session session = null;
        List<Contract> contractList = new ArrayList<Contract>();
        try {
            String queryText =
                    "SELECT f " +
                    "FROM Contract f ";
            session = Database.getFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(queryText);
            contractList = query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contractList;
    }

    public List<Contract> listContractsOfCustomer(Customer customer) {
        Session session = null;
        List<Contract> contractList = new ArrayList<Contract>();
        try {
            String queryText =
                    "SELECT f " +
                    "FROM Contract f " +
                    "WHERE f.customer = :ctmr";
            session = Database.getFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(queryText);
            if (customer != null) {
                query.setInteger("ctmr", customer.getCustomerId());
            }
            contractList = query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contractList;
    }

    public List<Contract> listContractsByPhone(String phone) {
        Session session = null;
        List<Contract> contractList = new ArrayList<Contract>();
        try {
            String queryText =
                    "SELECT f " +
                            "FROM Contract f " +
                            "WHERE f.phoneNumber = :phone";
            session = Database.getFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(queryText);
            query.setString("phone", phone);
            contractList = query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contractList;
    }
}
