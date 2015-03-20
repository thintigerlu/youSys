package com.lu.web.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lu.model.account.Account;
import com.lu.model.account.GetAccountRequest;
import com.lu.model.account.GetAccountResponse;
import com.lu.model.account.Holding;

@RestController
@RequestMapping("/account")
public class AccountController {
    @RequestMapping(value = "/getAccount")
    public GetAccountResponse login(@RequestBody GetAccountRequest request) {
    	System.out.println("============"+request.getLoginId());
    	GetAccountResponse response = new GetAccountResponse();
    	Account account = new Account();
    	account.setId(request.getLoginId());
    	account.setHoldings(new ArrayList<Holding>());
    	response.setAccount(account);
    	Holding h1 = new Holding();
    	h1.setName("IBM");
    	h1.setBalance("10000");
    	h1.setBuyTime("2015/01/01");
    	Holding h2 = new Holding();
    	h2.setName("Microsoft");
    	h2.setBalance("20000");
    	h2.setBuyTime("2015/03/01");
    	account.getHoldings().add(h1);
    	account.getHoldings().add(h2);
		return response;
    }

}
