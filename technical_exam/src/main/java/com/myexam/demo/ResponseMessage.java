package com.myexam.demo;

public class ResponseMessage {

    private int customerNumber;
    private int transactionStatusCode;
    private String transactionStatusDescription;

    public ResponseMessage(int customerNumber, int transactionStatusCode, String transactionStatusDescription) {
        this.customerNumber = customerNumber;
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public String getTransactionStatusDescription() {
        return transactionStatusDescription;
    }
}
