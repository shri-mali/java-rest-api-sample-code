/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author srika
 */

//account pojo 
public class Account implements Serializable{
    
    private static final long serialVersionUID = -7788619177798333713L;
    
    private String accountNumber;
    private String accountName;
    private String accountType;
    private String currency;
    private Date balanceDate;
    private Double balance;
    private List<Transaction> transactions;
    
    public Account(){
        
    }
    

    public Account(String accountNumber, String accountName, String accountType, String currency, Date balanceDate, Double balance, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.currency = currency;
        this.balanceDate = balanceDate;
        this.balance = balance;
        this.transactions = transactions;
    }

    
    
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonSerialize(using=DateSerializer.class)
    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction> transactionsList() {
        return transactions;
    }

    
    
    
}
