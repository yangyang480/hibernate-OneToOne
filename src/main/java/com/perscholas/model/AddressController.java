package com.perscholas.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class AddressController {

    //create method enable to create tables
    public void createTables()
    {
        SessionFactory session = new Configuration().configure().buildSessionFactory();
        session.openSession();
    }

    //create method
    public void InsertInfo(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Address address1 = new Address();
        address1.setAddressId(1);
        address1.setCity("stlouispark");
        address1.setState("MN");
        address1.setStreet("Minnetonka");
        address1.setZipcode(55426);

        Address address2 = new Address();
        address2.setAddressId(2);
        address2.setCity("Stpaul");
        address2.setState("MN");
        address2.setStreet("St");
        address2.setZipcode(55444);

        Address address3 = new Address();
        address3.setAddressId(3);
        address3.setCity("Edina");
        address3.setState("MN");
        address3.setStreet("ed");
        address3.setZipcode(55432);

        Person person1 = new Person();
        person1.setName("Yangyang");
        person1.setAge(29);
        person1.setEmail("yangyangzhao1213@gamil.com");
        person1.setHobby("Swim");
        person1.setJob("Developer");
        person1.setMyaddress(address1);

        Person person2 = new Person();
        person2.setName("Kyle");
        person2.setAge(32);
        person2.setEmail("kyle@gamil.com");
        person2.setHobby("Run");
        person2.setJob("Teache");
        person2.setMyaddress(address2);

        Person person3 = new Person();
        person3.setName("Marlin");
        person3.setAge(83);
        person3.setEmail("marlin@gamil.com");
        person3.setHobby("pazzle");
        person3.setJob("grandma");
        person3.setMyaddress(address3);

        session.save(address1);
        session.save(address2);
        session.save(address3);
        session.save(person1);
        session.save(person2);
        session.save(person3);

        transaction.commit();
        session.close();
        factory.close();
    }

    public void updateinsert(){
         String name;
         String email;
         int age;
         String hobby;
         String job;
         String street;
         String city;
         String state;
         int zipcode;

        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Enter your email: ");
        email = scanner.nextLine();
        System.out.println("Enter your age: ");
        age = scanner.nextInt();
        System.out.println("Enter your hobby: ");
        hobby = scanner.nextLine();
        System.out.println("Enter your job: ");
        job = scanner.nextLine();
        System.out.println("Enter your street: ");
        street = scanner.nextLine();
        System.out.println("Enter your city: ");
        city = scanner.nextLine();
        System.out.println("Enter your state: ");
        state = scanner.nextLine();
        System.out.println("Enter your zipcode: ");
        zipcode = scanner.nextInt();

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        String que = "INSERT INTO onetoone (name, email, age, hobby, job, street, city, state, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        TypedQuery typedQuery = session.createSQLQuery(que);
        typedQuery.setParameter(1, name);
        typedQuery.setParameter(2, email);
        typedQuery.setParameter(3, age);
        typedQuery.setParameter(4, hobby);
        typedQuery.setParameter(5, job);
        typedQuery.setParameter(6, street);
        typedQuery.setParameter(7, city);
        typedQuery.setParameter(8, state);
        typedQuery.setParameter(9, zipcode);

        transaction.commit();
        System.out.println("Successfully saved");
        factory.close();
        session.close();
    }

    //this is how we make it dynamic.
    public void getpersoninfo()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery typedQuery = session.createQuery("SELECT p, a FROM Person p INNER JOIN Address a ON a.AddressId = p.myaddress");
        List<Object[]> result = typedQuery.getResultList();
        for (Object[] e: result)
        {
            System.out.println(e[0]);//this return type will be object Person@516735765423, then we need to cascading.
            System.out.println(e[1]);
            //this is the right way to do below
            Person person = (Person) e[0];
            Address address = (Address) e[1];
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
            System.out.println("Email: " + person.getEmail());
            System.out.println("Hobby: " + person.getHobby());
            System.out.println("Address: " + address.getStreet() + " " + address.getCity() + " " + address.getState() + " " + address.getZipcode());
        }
    }

}
