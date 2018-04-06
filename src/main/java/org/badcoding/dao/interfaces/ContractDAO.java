package org.badcoding.dao.interfaces;

import org.badcoding.hibernate.stored.Contract;

import java.util.List;

public interface ContractDAO {
    void addContract(Contract contract);

    void updateContract(Contract contract);

    void removeContract(Contract contract);

    Contract getContractById(int id);

    List<Contract> listContracts();
}
