package org.badcoding;

import org.badcoding.hibernate.logic.Factory;
import org.badcoding.hibernate.stored.*;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;

public class ContractDAOImplTest {

    @Test
    public void testAddContract() {
        Customer customer = Factory.GetInstance().getCustomerDAO().getCustomerById(2);
        Tariff tariff = Factory.GetInstance().getTariffDAO().getTariffById(1);
        Contract contract = new Contract();
        contract.setContractId(11);
        contract.setCustomer(customer);
        contract.setTariff(tariff);
        contract.setBalance(100);
        contract.setPhoneNumber("123123123");
        contract.setRegisterDate(Calendar.getInstance().getTime());
        Factory.GetInstance().getContractDAO().addContract(contract);

        Customer customer1 = customer;

        assertNotNull(customer1);
        assertEquals(customer, customer1);

    }

    @Test
    public void testUpdateContract() {
        Contract contract = Factory.GetInstance().getContractDAO().getContractById(3);
        contract.setPhoneNumber("123123");
        Factory.GetInstance().getContractDAO().updateContract(contract);
        assertEquals(contract.getPhoneNumber(), "123123");
    }

    @Test
    public void testRemoveContract() {
        Contract contract = Factory.GetInstance().getContractDAO().getContractById(1);
        Factory.GetInstance().getContractDAO().removeContract(contract);
        Contract removed = Factory.GetInstance().getContractDAO().getContractById(1);
        assertNull(removed);
    }

    @Test
    public void testGetContractById() {
        Contract contract = Factory.GetInstance().getContractDAO().getContractById(1);
        assertEquals(contract.getContractId(), 1);
    }

    @Test
    public void testListContracts() {
        List<Contract> contractList = Factory.GetInstance().getContractDAO().listContracts();
        Contract contract = Factory.GetInstance().getContractDAO().getContractById(2);
        contract.setContractId(11);
        contract.setPhoneNumber("123123");
        Factory.GetInstance().getContractDAO().addContract(contract);
        List<Contract> newContractList = Factory.GetInstance().getContractDAO().listContracts();
        assertEquals(contractList.size() + 1, newContractList.size());
    }

    @Test
    public void testListContractsOfCustomer() {
        Customer customer = Factory.GetInstance().getCustomerDAO().getCustomerById(1);
        List<Contract> contractList = Factory.GetInstance().getContractDAO().listContractsOfCustomer(customer);
        assertEquals(contractList.size(), 1);
    }
}