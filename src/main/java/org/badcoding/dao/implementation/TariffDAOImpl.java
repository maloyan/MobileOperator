package org.badcoding.dao.implementation;

import org.badcoding.dao.interfaces.TariffDAO;
import org.badcoding.hibernate.stored.Tariff;
import org.badcoding.hibernate.logic.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.hibernate.Query;
import org.hibernate.Session;

@Service
public class TariffDAOImpl implements TariffDAO {

    public void addTariff(Tariff tariff) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.save(tariff);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateTariff(Tariff tariff) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.update(tariff);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void removeTariff(Tariff tariff) {
        Session session = null;
        try {
            session = Database.getFactory().openSession();
            session.beginTransaction();
            session.delete(tariff);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Tariff getTariffById(int id) {
        Session session = null;
        Tariff tariff = null;
        try {
            session = Database.getFactory().openSession();
            tariff = (Tariff)session.get(Tariff.class, id);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tariff;
    }

    public List<Tariff> listTariffs() {

        return null;
    }

}
