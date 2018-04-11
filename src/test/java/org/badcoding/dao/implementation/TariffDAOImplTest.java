package org.badcoding.dao.implementation;

import org.badcoding.hibernate.stored.Tariff;
import org.badcoding.hibernate.logic.Factory;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TariffDAOImplTest {

    @Test
    public void testAddTariff() {
        Tariff tariff = Factory.GetInstance().getTariffDAO().getTariffById(1);
        Tariff newTariff = tariff;
        newTariff.setTariffId(4);
        newTariff.setName("SuperTariff");
        List<Tariff> tariffList = Factory.GetInstance().getTariffDAO().listTariffs();
        Factory.GetInstance().getTariffDAO().addTariff(newTariff);
        List<Tariff> newTariffList = Factory.GetInstance().getTariffDAO().listTariffs();
        assertEquals(tariffList.size() + 1, newTariffList.size());
    }

    @Test
    public void removeTariff() {
        Tariff tariff = new Tariff();
        tariff.setTariffId(10);
        tariff.setName("slkjfklsdfj");
        Factory.GetInstance().getTariffDAO().addTariff(tariff);
        Factory.GetInstance().getTariffDAO().removeTariff(tariff);
    }
}