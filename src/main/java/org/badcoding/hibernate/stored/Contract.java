package org.badcoding.hibernate.stored;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Contract")
public class Contract {
    private int contractId;
    private String phoneNumber;
    private int balance;
    private String registerDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Contract_ID", nullable = false)
    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    
    @Basic
    @Column(name = "phone_number", nullable = true, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    @Basic
    @Column(name = "balance", nullable = false)
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    
    @Basic
    @Column(name = "register_date", nullable = true, length = 45)
    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return contractId == contract.contractId &&
                balance == contract.balance &&
                Objects.equals(phoneNumber, contract.phoneNumber) &&
                Objects.equals(registerDate, contract.registerDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(contractId, phoneNumber, balance, registerDate);
    }
}
