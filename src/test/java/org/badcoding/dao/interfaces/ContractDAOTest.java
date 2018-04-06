package org.badcoding.dao.interfaces;

import static org.testng.Assert.*;

import org.badcoding.hibernate.logic.Factory;
import org.badcoding.hibernate.stored.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContractDAOTest extends Assert{

    @Test
    public void testAddContract() {
        Contract contract = new Contract();
        contract.setBalance(100);
        contract.setPhoneNumber("123123123");
        contract.setRegisterDate("2017-01-01");
        Factory.GetInstance().getContractDAO().addContract(contract);

        Contract contract1 = Factory.GetInstance().getContractDAO().getContractById(1);
        assertNotNull(contract1);
        /*
        contract.setContractId(10);

        Contract newContract = Factory.GetInstance().getContractDAO().getContractById(10);

        assertNotNull(newContract);
        assertEquals(newContract.getContractId(), contract.getContractId());
        */
    }

    @Test
    public void testUpdateContract() {
        Contract contract = Factory.GetInstance().getContractDAO().getContractById(1);
        contract.setPhoneNumber("123123");
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
        assertEquals(contractList.size(), 4);
    }
}