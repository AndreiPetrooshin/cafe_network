package com.andreipetrooshin.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Director {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Cafe> cafeList = new ArrayList<Cafe>();

    public Director(int id,String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Director(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Director() {
    }

    @OneToMany(mappedBy = "director", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Cafe> getCafeList() {
        return cafeList;
    }

    public void setCafeList(List<Cafe> cafeList) {
        this.cafeList = cafeList;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Director director = (Director) o;

        if (id != director.id) return false;
        if (firstName != null ? !firstName.equals(director.firstName) : director.firstName != null) return false;
        if (lastName != null ? !lastName.equals(director.lastName) : director.lastName != null) return false;
        if (email != null ? !email.equals(director.email) : director.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(director.phoneNumber) : director.phoneNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' + '}';
    }
}
