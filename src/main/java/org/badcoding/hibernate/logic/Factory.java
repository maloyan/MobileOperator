package org.badcoding.hibernate.logic;

import org.badcoding.dao.interfaces.*;
import org.badcoding.dao.implementation.*;
import org.w3c.dom.UserDataHandler;

public class Factory {
	private static CustomerDAO customer = null;
	private static ContractDAO contract = null;
	private static ServiceDAO service = null;
	private static EventDAO event = null;
	private static TariffDAO tariff = null;
    private static UserDAO user = null;

	private static Factory instance = null;

	public static synchronized Factory GetInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}
	
	public CustomerDAO getCustomerDAO() {
		if (customer == null) {
            customer = new CustomerDAOImpl();
		}
		return customer;
	}

    public ContractDAO getContractDAO() {
        if (contract == null) {
            contract = new ContractDAOImpl();
        }
        return contract;
    }

    public ServiceDAO getServiceDAO() {
        if (service == null) {
            service = new ServiceDAOImpl();
        }
        return service;
    }

    public EventDAO getEventDAO() {
        if (event == null) {
            event = new EventDAOImpl();
        }
        return event;
    }

    public TariffDAO getTariffDAO() {
        if (tariff == null) {
            tariff = new TariffDAOImpl();
        }
        return tariff;
    }

    public UserDAO getUserDAO() {
        if (user == null) {
            user = new UserDAOImpl();
        }
        return user;
    }
}

