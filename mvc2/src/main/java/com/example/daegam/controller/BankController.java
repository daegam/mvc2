package com.example.daegam;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.daegam.dao.BankAccountDao;
import com.example.daegam.dao.BankCustomerDao;
import com.example.daegam.vo.BankAccount;
import com.example.daegam.vo.BankCustomer;
import com.example.daegam.vo.BankCustomerAccount;
import com.example.daegam.vo.BankCustomerPage;
import com.example.daegam.vo.Member1;

@Controller
public class BankController {

	@Resource(name = "bankCustomerDao")
	private BankCustomerDao bankCustmoerDao;
	
	@Resource(name = "bankAccountDao")
	private BankAccountDao bankAccountDao;
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> valueOps;


	public static final Logger Logger = LoggerFactory.getLogger(BankController.class);

	
	@RequestMapping(value = "/joinCustomer.do", method = RequestMethod.GET)
	public ModelAndView joinCustomer_GET() {
		return new ModelAndView("joinBankCustomer", "bankCustomer", new BankCustomer());
	}

	
	@RequestMapping(value = "/joinCustomer.do", method = RequestMethod.POST)
	public String joinCustomer_POST(@ModelAttribute("bankCustomer") BankCustomer bankCustomer) {

		bankCustmoerDao.joinBankCustmoer(bankCustomer);

		return "redirect:getCustomerList.do";
	}

	
	@RequestMapping(value = "/getCustomerList.do", method = RequestMethod.GET)
	public String getCustomerList(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "s_type", required = false, defaultValue = "customer_no") String s_type,
			@RequestParam(value = "s_text", required = false, defaultValue = "") String s_text) {

		BankCustomerPage bankCustomerPage = new BankCustomerPage();
		int start = (page - 1) * 5;
		bankCustomerPage.setStart(start);
		try {
			s_text = new String(s_text.getBytes("8859_1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		bankCustomerPage.setS_text(s_text);
		bankCustomerPage.setS_type(s_type);
		
		int totalPage = (bankCustmoerDao.getBankCusttomerCount(bankCustomerPage)-1)/5+1;
		List<BankCustomer> bankCustomers = bankCustmoerDao.getBankCusttomerList(bankCustomerPage);
		
		model.addAttribute("s_text", s_text);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("bankCustomers", bankCustomers);

		return "bankCustomerList";
	}
	
	//계좌등록
	@RequestMapping(value = "/accountReg.do", method = RequestMethod.GET)
	public ModelAndView accountReg(@RequestParam(value="customer_no") int customer_no) {
		return new ModelAndView("accountReg", "account", new BankAccount(customer_no));
	}
	@RequestMapping(value = "/accountReg.do", method = RequestMethod.POST)
	public String accountReg(@ModelAttribute("account") BankAccount account) {
		bankAccountDao.accountReg(account);
		return "redirect:customerAccount.do?customer_no=" + account.getCustomer_no();
	}
	
	//고객계좌확인
	@RequestMapping(value = "/customerAccount.do", method = RequestMethod.GET)
	public String customerAccount(@RequestParam(value="customer_no") int customer_no, Model model) {
		List<BankCustomerAccount> bca = bankCustmoerDao.getBankCustomerAccountList(customer_no);
		
		if(bca.size()>0){
			model.addAttribute("BankCustomerAccount", bca); 
		}
		return "bankCustomerAccount";
	}
	
	//계좌 입금
	@RequestMapping(value = "/deposit.do", method = RequestMethod.GET)
	public ModelAndView deposit(@RequestParam(value="customer_no") String customer_no, @RequestParam(value="account_no") String account_no) {
		
		//해당계좌 정보 가져오기
		BankAccount account = bankAccountDao.getAccount(account_no);
		
		return new ModelAndView("accountDeposit", "accountDeposit", account);
	}
	@RequestMapping(value = "/deposit.do", method = RequestMethod.POST)
	public String deposit(@ModelAttribute(value="accountDeposit") BankAccount accountDeposit) {

		//db로 가서 입금처리
		int ret = bankAccountDao.accountDeposit(accountDeposit);
		
		if(ret>0){
			System.out.println("입금완료");
		}else{
			System.out.println("입금실패");
		}
		
		return "redirect:customerAccount.do?customer_no=" + accountDeposit.getCustomer_no();
	}
	
	//계좌 출금
	@RequestMapping(value = "/withdrawal.do", method = RequestMethod.GET)
	public ModelAndView withdrawal(@RequestParam(value="customer_no") String customer_no, @RequestParam(value="account_no") String account_no) {
		
		//해당계좌 정보 가져오기
		BankAccount account = bankAccountDao.getAccount(account_no);
		
		return new ModelAndView("accountWithdrawal", "accountWithdrawal", account);
	}
	
	@RequestMapping(value = "/withdrawal.do", method = RequestMethod.POST)
	public String withdrawal(@ModelAttribute(value="accountWithdrawal") BankAccount accountWithdrawal) {
		
		//db로 가서 출금처리
		int ret = bankAccountDao.accountWithdrawal(accountWithdrawal);		
		if(ret>0){
			System.out.println("출금완료");
		}else{
			System.out.println("출금실패");
		}
		
		return "redirect:customerAccount.do?customer_no=" + accountWithdrawal.getCustomer_no();
	}
	
	@RequestMapping(value = "/redis", method = RequestMethod.GET)
	public @ResponseBody String redis() {
		valueOps.set("daegam", new String("test!!"));
		String ret = (String)valueOps.get("daegam");
		
		return ret;
	}
	
	@RequestMapping(value = "/testlogin", method = RequestMethod.GET)
	public ModelAndView test_login() {
		return new ModelAndView("test_login", "test_login", new Member1());
	}
	
	@RequestMapping(value = "/redis1", method = RequestMethod.POST)
	public @ResponseBody String redis1(@ModelAttribute Member1 member1){
		
		valueOps.set("mem1", member1);
		
		Member1 ret = (Member1)valueOps.get("mem1");

		return ret.getId();
	}
}