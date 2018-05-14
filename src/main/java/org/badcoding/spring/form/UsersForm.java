package org.badcoding.spring.form;

public class UsersForm {
	private String id;
	private String first_name;
	private String last_name;
    private String company;
    private String email;
    private String address;
    private String personal_or_commercial;
    private String passport;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonal_or_commercial() {
        return personal_or_commercial;
    }

    public void setPersonal_or_commercial(String personal_or_commercial) {
        this.personal_or_commercial = personal_or_commercial;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

}
