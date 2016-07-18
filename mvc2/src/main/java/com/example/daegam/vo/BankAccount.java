package com.example.daegam.vo;

public class BankAccount {
	private String account_no;
	private int customer_no;
	private int account_money;
	private String account_date;
	private int deposit_money;
	private int withdrawal_money;
	
	public BankAccount(){
		
	}
	
	public BankAccount(int customer_no) {
		this.customer_no = customer_no;
	}
	
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getAccount_date() {
		return account_date;
	}
	public void setAccount_date(String account_date) {
		this.account_date = account_date;
	}

	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}

	public int getAccount_money() {
		return account_money;
	}

	public void setAccount_money(int account_money) {
		this.account_money = account_money;
	}

	public int getDeposit_money() {
		return deposit_money;
	}

	public void setDeposit_money(int deposit_money) {
		this.deposit_money = deposit_money;
	}

	public int getWithdrawal_money() {
		return withdrawal_money;
	}

	public void setWithdrawal_money(int withdrawal_money) {
		this.withdrawal_money = withdrawal_money;
	}
}