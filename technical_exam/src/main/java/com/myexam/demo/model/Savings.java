package com.myexam.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Savings {

    private @Id
    @GeneratedValue Long id;
    private int accountNumber;
    private String accountType;
    private int availableBalance;

    @ManyToOne
    @JoinColumn(name="customer_Id", nullable=false)
    @JsonBackReference
    private Account account;

    public Savings(){

    }

    public Savings(int accountNumber, String accountType, int availableBalance, Account account) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.availableBalance = availableBalance;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Savings{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                ", availableBalance=" + availableBalance +
                ", account=" + account +
                '}';
    }
}
