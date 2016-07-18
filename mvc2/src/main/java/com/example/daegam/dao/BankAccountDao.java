package com.example.daegam.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.example.daegam.vo.BankAccount;


public class BankAccountDao extends SqlSessionDaoSupport {
	
	//계좌등록
	public void accountReg(BankAccount bankAccount) {
		this.getSqlSession().insert("BankAccount.reg", bankAccount);
	}
	
	//해당 계좌 가져오기
	public BankAccount getAccount(String account_no){
		return this.getSqlSession().selectOne("BankAccount.getAccount", account_no);
	}
	
	//계좌입금
	public int accountDeposit(BankAccount accountDeposit){
		return this.getSqlSession().update("BankAccount.deposit", accountDeposit);
	}
	
	//계좌출금
	public int accountWithdrawal(BankAccount accountWithdrawal){
		return this.getSqlSession().update("BankAccount.withdrawal", accountWithdrawal);
	}
}