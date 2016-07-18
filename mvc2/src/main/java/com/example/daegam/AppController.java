package com.example.daegam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.daegam.dao.BankCustomerDao;
import com.example.daegam.dao.BoardDao;
import com.example.daegam.dao.CommonDao;
import com.example.daegam.vo.AppMember;
import com.example.daegam.vo.BankCustomer;
import com.example.daegam.vo.Board;
import com.example.daegam.vo.Item;
import com.example.daegam.vo.Member;

@Controller
public class AppController {

	@Resource(name = "objDao")
	private CommonDao objDao;

	@Resource(name = "boardDao")
	private BoardDao boardDao;
	
	@Resource(name = "bankCustomerDao")
	private BankCustomerDao bankCustomerDao;

	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	@RequestMapping(value = "/applogin")
	public @ResponseBody Map<String, String> applogin(HttpServletResponse response) {

		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		Map<String, String> map = new HashMap<String, String>();
		map.put("data1", "abc1");
		map.put("data2", "def");
		map.put("data3", "ddd");

		return map;
	}

	@RequestMapping(value = "/applogin1")
	public @ResponseBody Vector<Map<String, String>> applogin1(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		Vector<Map<String, String>> vec = new Vector<Map<String, String>>();

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "abc1");
		map.put("pw", "abc2");
		map.put("name", "abc3");

		vec.add(map);
		vec.add(map);
		vec.add(map);

		return vec;
	}

	@RequestMapping(value = "/applogin2")
	public @ResponseBody Member applogin2(HttpServletResponse response, @RequestParam("id") String id) {

		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		Member mem = objDao.getMemberOne(id);

		return mem;
	}

	@RequestMapping(value = "/appboard")
	public @ResponseBody List<Board> appboard(HttpServletResponse response,
			@RequestParam(value = "start", required = false, defaultValue = "0") int start) {

		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		List<Board> list = boardDao.getBoardListJson(start);

		return list;
	}

	// 127.0.0.1:8080/mvc2/appidcheck
	@RequestMapping(value = "/appidcheck")
	public @ResponseBody Map<String, Integer> appidcheck(HttpServletResponse response,
			@RequestParam(value = "id", required = false, defaultValue = "") String userid) {

		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String ret_id = objDao.searchId(userid);

		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("ret", 1);

		if (ret_id != null) {
			map.put("ret", 0);
		}
		return map;
	}

	// 127.0.0.1:8080/mvc2/appidcheck
	@RequestMapping(value = "/appjoin")
	public @ResponseBody Map<String, String> appjoin(HttpServletResponse response,
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "pwd", required = false, defaultValue = "") String pwd,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {

		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		Member member = new Member(id, pwd, name);

		Map<String, String> map = new HashMap<String, String>();

		try {
			objDao.join(member);
			map.put("ret", "가입성공");
		} catch (Exception e) {
			map.put("ret", "가입실패");
		}
		return map;
	}

	// @RequestMapping(value = "/itemlist", method = RequestMethod.POST)
	@RequestMapping(value = "/itemlist", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List<Item> itemlist(HttpServletResponse response,
			@RequestParam(value = "start", required = false, defaultValue = "0") int start) {

		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		List<Item> list = objDao.getItemList(start);

		return list;
	}

	@RequestMapping(value = "/medit.do", method = RequestMethod.GET)
	public @ResponseBody AppMember mEdit(HttpServletResponse response, @RequestParam(value = "id", required = false, defaultValue = "") String id) {

		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");

		AppMember e_member = objDao.getOneMember(id);

		if (e_member != null) {
			return e_member;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/medit.do", method = RequestMethod.POST)
	public @ResponseBody String mEdit(HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		return null;
	}
	
	@RequestMapping(value = "/customerlist.do", method = RequestMethod.GET)
	public @ResponseBody List<BankCustomer> getCustomerList(HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		List<BankCustomer> customerList = bankCustomerDao.appCustomerList();
		
		return customerList;
	}
	
	
		
	@RequestMapping(value = "/customeredit.do", method = RequestMethod.POST)
	public String editCustomer() {
		System.out.println("놀래라");
		return "redirect:customerlist.do";
	}	
}