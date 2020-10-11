/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.controller;

import com.rest.dao.AccountDAO;
import com.rest.exception.RecordNotFoundException;
import com.rest.model.Account;
import com.rest.model.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author srika
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    //connect to account repository
    @Autowired
    private AccountDAO accountDAO;

    //get user accounts information using /api/accounts/USER_ID
    @RequestMapping(value = "/{userId}", produces = "application/json")
    public ResponseEntity<Object> getUserAccount(@PathVariable("userId") Long userId) {
        //check if the user exsists in the repository
        User user = accountDAO.getUsers().get(userId);
        if (user == null) {
            //throw 404 if the user is not found 
            throw new RecordNotFoundException("User with id - " + userId + " is not found.");
        } else {
            //user account found, retutn accounts information
            return new ResponseEntity<>(user.getAccounts().values(), HttpStatus.OK);
        }
    }

    //get transaction information using /api/accounts/USER_ID/ACCOUNT_NUMBER
    @RequestMapping(value = "/{userId}/{accountId}", produces = "application/json")
    public ResponseEntity<Object> getUserAccountTransactions(@PathVariable("userId") Long userId, @PathVariable("accountId") String accountId) {
        //check if the user exsists in the repository
        User user = accountDAO.getUsers().get(userId);
        if (user == null) {
            //throw 404 if the user is not found 
            throw new RecordNotFoundException("User with id - " + userId + " is not found.");
        } else {
            Account account = user.getAccounts().get(accountId);
            //check if the account exsists in the repository
            if (account == null) {
                //throw 404 if the account is not found 
                throw new RecordNotFoundException("Account with id - " + accountId + " is not found.");
            } else {
                 //user and account found, return transactions information
                return new ResponseEntity<>(account.transactionsList(), HttpStatus.OK);
            }
        }
    }
}
