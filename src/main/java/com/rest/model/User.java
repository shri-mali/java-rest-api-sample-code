/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.model;

import java.io.Serializable;
import java.util.HashMap;


/**
 *
 * @author srika
 */
//User POJO
public class User implements Serializable{

    private static final long serialVersionUID = -7788619177798333712L;
    
    //user id
    private Long id;
    private HashMap<String,Account> accounts;

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HashMap<String,Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String,Account> accounts) {
        this.accounts = accounts;
    }

}
