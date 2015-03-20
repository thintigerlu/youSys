package com.lu.model.account;

import com.lu.model.Response;

public class GetAccountResponse extends Response{
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
