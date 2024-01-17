package com.myexam.demo;

public class ErrorMessage {

    private int transactionStatusCode;
    private String transactionStatusDescription;

    public ErrorMessage(int transactionStatusCode, String transactionStatusDescription) {
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public int getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public String getTransactionStatusDescription() {
        return transactionStatusDescription;
    }

}
