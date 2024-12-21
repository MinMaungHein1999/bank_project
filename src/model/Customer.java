package model;

import java.sql.Date;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String nrc;
    private String phone;
    private String address;
    private CustomerStatus status;
    private Date dateOfBirth;
    private Date confirmedAt;
    private Date createdAt;
    private Date updatedAt;
    private Employee CreatedBy;
    private Employee updatedBy;

    public Customer(){

    }

    public Customer(int id, String firstName, String lastName, String email, String nrc, String phone, String address, CustomerStatus status, Date dateOfBirth, Date confirmedAt, Date createdAt, Date updatedAt, Employee createdBy, Employee updatedBy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nrc = nrc;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.confirmedAt = confirmedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        CreatedBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", nrc='" + nrc + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", dateOfBirth=" + dateOfBirth +
                ", confirmedAt=" + confirmedAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", CreatedBy=" + CreatedBy +
                ", updatedBy=" + updatedBy +
                '}';
    }

}
