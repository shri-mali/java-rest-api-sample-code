/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.dao;

import com.rest.model.Account;
import com.rest.model.Transaction;
import com.rest.model.User;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Repository;

/**
 *
 * @author srika
 */
//repository class
@Repository
public class AccountDAO {

    private static HashMap<Long, User> users = new LinkedHashMap<Long, User>();

    static {

        //creating three new random users
        User user1 = new User(1L);
        User user2 = new User(2L);
        User user3 = new User(3L);
        //add accounts and transactions
        loadRandomAccountsAndTransactionsInUser(user1);
        loadRandomAccountsAndTransactionsInUser(user2);
        loadRandomAccountsAndTransactionsInUser(user3);

        //add users to hashmap
        users.put(1L, user1);
        users.put(2L, user2);
        users.put(3L, user3);

    }

    private static void loadRandomAccountsAndTransactionsInUser(User user) {
        List<Transaction> transactions = new LinkedList<>();
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 1231.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 1232.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 1233.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 1234.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 1235.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 1236.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 1237.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 1238.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 1239.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 12310.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 12311.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 12312.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 12313.0, "Credit", ""));
        transactions.add(new Transaction("123", "SavingsAU1", new Date(), "AU", 0.0, 12314.0, "Credit", ""));

        HashMap<String, Account> accounts = new LinkedHashMap<>();
        accounts.put("123", new Account("123", "SavingsAU1", "Savings", "AU", new Date(), 1234.12, transactions));
        accounts.put("124", new Account("124", "SavingsAU1", "Savings", "AU", new Date(), 1235.12, transactions));
        accounts.put("125", new Account("125", "SavingsAU1", "Savings", "AU", new Date(), 1236.12, transactions));
        accounts.put("126", new Account("126", "SavingsAU1", "Savings", "AU", new Date(), 1237.12, transactions));

        user.setAccounts(accounts);

    }

    public HashMap<Long, User> getUsers() {
        return users;
    }

}
