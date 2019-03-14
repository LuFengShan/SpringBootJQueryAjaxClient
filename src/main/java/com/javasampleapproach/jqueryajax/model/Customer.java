package com.javasampleapproach.jqueryajax.model;

/**
 * 消费者
 */
public class Customer {
    /**
     * 名字
     */
    private String firstname;
    /**
     * 姓氏
     */
    private String lastname;

    public Customer() {
    }

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // firstname
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // lastname
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}