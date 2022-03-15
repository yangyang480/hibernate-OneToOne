package com.perscholas.model;

import javax.persistence.*;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private int PersonId;
    private String name;
    private String email;
    private int age;
    private String hobby;
    private String job;
    //decalre address class here
    @OneToOne(cascade = CascadeType.ALL)
    private Address myaddress;

    public Person(){

    }

    public Person(int personId, String name, String email, int age, String hobby, String job, Address myaddress) {
        PersonId = personId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.hobby = hobby;
        this.job = job;
        this.myaddress = myaddress;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Address getMyaddress() {
        return myaddress;
    }

    public void setMyaddress(Address myaddress) {
        this.myaddress = myaddress;
    }

    //once the class created, we can mapping in the hibernate xml.
}
