package org.badcoding.hibernate.stored;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Customer")
public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String address;
    private String commersialOrPersonal;
    private String passport;

    @Id
    @Column(name = "Customer_ID", nullable = false)
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    
    @Basic
    @Column(name = "first_name", nullable = true, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Basic
    @Column(name = "last_name", nullable = true, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Basic
    @Column(name = "company", nullable = true, length = 45)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    
    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    @Basic
    @Column(name = "address", nullable = false, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    @Basic
    @Column(name = "commersial_or_personal", nullable = false, length = 45)
    public String getCommersialOrPersonal() {
        return commersialOrPersonal;
    }

    public void setCommersialOrPersonal(String commersialOrPersonal) {
        this.commersialOrPersonal = commersialOrPersonal;
    }

    
    @Basic
    @Column(name = "passport", nullable = false, length = 45)
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(company, customer.company) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(commersialOrPersonal, customer.commersialOrPersonal) &&
                Objects.equals(passport, customer.passport);
    }

    @Override
    public int hashCode() {

        return Objects.hash(customerId, firstName, lastName, company, email, address, commersialOrPersonal, passport);
    }
}
