package org.badcoding.test;

import org.badcoding.hibernate.logic.Factory;
import org.badcoding.hibernate.stored.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContractDAOTest extends Assert{

    @Test
    public void testAddContract() {
        Contract contract = new Contract();
        contract.setBalance(100);
        contract.setContractId(10);
        contract.setPhoneNumber("123123123");
        contract.setRegisterDate("2017-01-01");

        Factory.GetInstance().getContractDAO().addContract(contract);
        Contract newContract = Factory.GetInstance().getContractDAO().getContractById(10);

        assertNotNull(newContract);
        assertEquals(newContract.getContractId(), contract.getContractId());

    }

    @Test
    public void testUpdateContract() {
    }

    @Test
    public void testRemoveContract() {
    }

    @Test
    public void testGetContractById() {
    }

    @Test
    public void testListContracts() {
    }
}