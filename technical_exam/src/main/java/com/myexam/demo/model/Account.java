package com.myexam.demo.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myexam.demo.ResponseMessage;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Account {

    private @Id
    @GeneratedValue Long customer_Id;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private String accountType;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Savings> savings;

    @Transient
    ResponseMessage responseMessage;

    public Account(){

    }

    public Account(String customerName, String customerMobile, String customerEmail,
                   String address1, String address2, String accountType) {
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
        this.address1 = address1;
        this.address2 = address2;
        this.accountType = accountType;
    }

    public Long getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(Long id) {
        this.customer_Id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public List<Savings> getSavings() {
        return savings;
    }

    public void setSavings(List<Savings> savings) {
        this.savings = savings;
    }

    public ResponseMessage getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(customer_Id, account.customer_Id) && Objects.equals(customerName, account.customerName) && Objects.equals(customerMobile, account.customerMobile) && Objects.equals(customerEmail, account.customerEmail) && Objects.equals(address1, account.address1) && Objects.equals(address2, account.address2) && Objects.equals(accountType, account.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_Id, customerName, customerMobile, customerEmail, address1, address2, accountType);
    }

    @Override
    public String toString() {
        return "Account{" +
                "customer_Id=" + customer_Id +
                ", customerName='" + customerName + '\'' +
                ", customerMobile='" + customerMobile + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
