package org.badcoding.spring.form;

import org.badcoding.dao.interfaces.ContractDAO;
import org.badcoding.dao.interfaces.CustomerDAO;
import org.badcoding.hibernate.stored.Contract;
import org.badcoding.hibernate.stored.Customer;
import org.badcoding.hibernate.stored.Tariff;

import java.util.Date;

public class ContractForm {
    private Integer id;
    private Integer customerId;
    private Integer tariffId;
    private String phoneNumber;
    private Integer balance;
    private Date registerDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getTariffId() {
        return tariffId;
    }

    public void setTariffId(Integer tariffId) {
        this.tariffId = tariffId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

}
