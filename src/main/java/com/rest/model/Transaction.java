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

/**
 *
 * @author srika
 */
//transaction POJO
public class Transaction implements Serializable{
    
    private static final long serialVersionUID = -7788619177798333714L;
    private String accountNumber;
    private String accountName;
    private Date valueDate;
    private String currency;
    private Double debitAmount;
    private Double creditAmount;
    private String debitORCredit;
    private String transactionNarrative;

    public Transaction(){
        
    }
    
    public Transaction(String accountNumber, String accountName, Date valueDate, String currency, Double debitAmount, Double creditAmount, String debitORCredit, String transactionNarrative) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.valueDate = valueDate;
        this.currency = currency;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.debitORCredit = debitORCredit;
        this.transactionNarrative = transactionNarrative;
        
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

    @JsonSerialize(using=DateSerializer.class)
    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(Double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getDebitORCredit() {
        return debitORCredit;
    }

    public void setDebitORCredit(String debitORCredit) {
        this.debitORCredit = debitORCredit;
    }

    public String getTransactionNarrative() {
        return transactionNarrative;
    }

    public void setTransactionNarrative(String transactionNarrative) {
        this.transactionNarrative = transactionNarrative;
    }
    
    
    
    
}
