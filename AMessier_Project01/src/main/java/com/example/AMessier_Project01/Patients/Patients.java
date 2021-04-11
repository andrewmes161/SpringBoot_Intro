package com.example.AMessier_Project01.Patients;

import javax.persistence.*; //
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table
public class Patients {
    @Id
    @SequenceGenerator(
            name = "patients_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patients_sequence"
    )

    //VARIABLES //

    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String gender;
    private LocalDate DOB;

    @Transient // Tells computer not to include in database (Getting from DOB)
    private Integer age;


    // BLANK CONSTRUCTOR //
    public Patients() {
    }

    // NO ID CONSTRUCTOR //
    public Patients(String firstName, String lastName, String emailAddress,
                    String phoneNumber, String gender, LocalDate DOB) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.DOB = DOB;

    }

    // EVERYTHING CONSTRUCTOR //
    public Patients(Long id, String firstName, String lastName,
                    String emailAddress, String phoneNumber,
                    String gender, LocalDate DOB) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.DOB = DOB;
    }

    // GETTERS AND  SETTERS //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public Integer getAge() {
        return Period.between(DOB, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // TO STRING METHOD //
    @Override
    public String toString() {
        return "Patients{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", DOB=" + DOB +
                ", age=" + age +
                '}';
    }
}
