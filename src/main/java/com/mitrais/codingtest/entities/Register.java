package com.mitrais.codingtest.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"mobileNumber","email"})})
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column
    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "([\\[\\(])?(?:(\\+62)|62|0)\\1?8(?!0|4|6)\\d(?!0)\\d\\d{3,4}\\d{3,5}()?\\b",message = "Mobile number must valid(+62)")
    private String mobileNumber;
    @Column
    @NotBlank(message = "First name is required")
    private String firstName;
    @Column
    @NotBlank(message = "Last name is required")
    private String lastName;
    @Column
    private String dateBirth;
    @Column
    private String gender;
    @Column
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateBirth=" + dateBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
