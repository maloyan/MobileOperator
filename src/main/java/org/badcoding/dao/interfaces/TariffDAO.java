package org.badcoding.dao.interfaces;

import org.badcoding.hibernate.stored.Tariff;

import java.util.List;

public interface TariffDAO {
    void addTariff(Tariff Tariff);

    void updateTariff(Tariff Tariff);

    void removeTariff(Tariff Tariff);

    Tariff getTariffById(int id);

    List<Tariff> listTariffs();
}
