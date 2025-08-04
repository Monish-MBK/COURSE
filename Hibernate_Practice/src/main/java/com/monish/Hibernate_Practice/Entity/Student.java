package com.monish.Hibernate_Practice.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "student_details")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sname",nullable = false)
    private String name;
    private Address address;
    @Lob
    private byte[] image;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date AdmissionDate;
    @Transient
    private long phoneNumber;

    public Student(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getAdmissionDate() {
        return AdmissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        AdmissionDate = admissionDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", image=" + Arrays.toString(image) +
                ", AdmissionDate=" + AdmissionDate +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public Student(int id, String name, Address address,byte[] image, Date admissionDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = image;
        AdmissionDate = admissionDate;
    }

    public Student() {
    }
}
