package dto;


import model.Employee;

import java.sql.Date;

public class CustomerDto {
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String nrc;
    private String phone;
    private String email;
    private String address;
    private Employee CreatedBy;
    private Employee updatedBy;

    public CustomerDto( String firstName, String lastName, Date dateOfBirth,String nrc,String phone,String email,  String address ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nrc = nrc;
        this.phone = phone;
        this.email = email;
        this.address =address;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(Employee createdBy) {
        CreatedBy = createdBy;
    }

    public Employee getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Employee updatedBy) {
        this.updatedBy = updatedBy;
    }
}
