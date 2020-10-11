/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author srika
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountRESTAPIApplication.class)
@WebAppConfiguration
public class AccountRESTAPITests {

    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getUserAccounts() throws Exception {
        //test for getting user accounts
        String uri = "/api/accounts/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        //test if the api responding with http 200 code
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

        JSONArray inputArray = new JSONArray(content);
        //check if all the required values are outputed in the api
        inputArray.getJSONObject(0).get("accountNumber");
        inputArray.getJSONObject(0).get("accountName");
        inputArray.getJSONObject(0).get("accountType");
        inputArray.getJSONObject(0).get("currency");
        inputArray.getJSONObject(0).get("balanceDate");
        inputArray.getJSONObject(0).get("balance");

        //test for user account not found
        uri = "/api/accounts/8";
        mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        status = mvcResult.getResponse().getStatus();
        //test if the api responding with http 404 code
        assertEquals(404, status);

    }

    @Test
    public void getUserAccountTransactions() throws Exception {
        //test for getting user account transactions
        String uri = "/api/accounts/1/123";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        //test if the api responding with http 200 code
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

        JSONArray inputArray = new JSONArray(content);
        //check if all the required values are outputed in the api
        inputArray.getJSONObject(0).get("accountNumber");
        inputArray.getJSONObject(0).get("accountName");
        inputArray.getJSONObject(0).get("valueDate");
        inputArray.getJSONObject(0).get("currency");
        inputArray.getJSONObject(0).get("debitAmount");
        inputArray.getJSONObject(0).get("creditAmount");
        inputArray.getJSONObject(0).get("debitORCredit");
        inputArray.getJSONObject(0).get("transactionNarrative");

        //test for user account not found
        uri = "/api/accounts/8/123";
        mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        status = mvcResult.getResponse().getStatus();
        //test if the api responding with http 404 code
        assertEquals(404, status);
        
        //test for user account transactions not found
        uri = "/api/accounts/1/111";
        mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        status = mvcResult.getResponse().getStatus();
        //test if the api responding with http 404 code
        assertEquals(404, status);
    }

    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }
}
