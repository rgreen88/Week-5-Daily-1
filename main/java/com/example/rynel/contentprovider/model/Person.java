package com.example.rynel.contentprovider.model;

/**
 * Created by Admin on 10/23/2017.
 */

public class Person {

    //constructor for person name and age
    private String firstName;
    private String lastName;
    private String age;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Person(String name, String show, String catchPhase) {
        this.firstName = name;
        this.lastName = show;
        this.age = catchPhase;
    }


}
