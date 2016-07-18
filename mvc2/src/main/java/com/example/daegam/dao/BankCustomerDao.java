package com.example.daegam.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.example.daegam.vo.BankCustomer;
import com.example.daegam.vo.BankCustomerAccount;
import com.example.daegam.vo.BankCustomerPage;

public class BankCustomerDao extends SqlSessionDaoSupport {
	public void joinBankCustmoer(BankCustomer bankCustomer){
		this.getSqlSession().insert("BankCustomer.join", bankCustomer);
	}
	
	public int getBankCusttomerCount(BankCustomerPage bankCustomerPage){
		return this.getSqlSession().selectOne("BankCustomer.getCount", bankCustomerPage);
	}
	
	public List<BankCustomer> getBankCusttomerList(BankCustomerPage bankCustomerPage){
		return this.getSqlSession().selectList("BankCustomer.getList", bankCustomerPage);
	}
	
	public List<BankCustomerAccount> getBankCustomerAccountList(int customer_no){
		return this.getSqlSession().selectList("BankCustomer.getCustomerAccount", customer_no);
	}
	
	public List<BankCustomer> appCustomerList(){
		return this.getSqlSession().selectList("BankCustomer.appList");
	}
}