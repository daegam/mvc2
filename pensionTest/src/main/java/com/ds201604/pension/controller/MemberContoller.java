package com.ds201604.pension.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ds201604.pension.dao.MemberDao;
import com.ds201604.pension.vo.Member;

@Controller
public class MemberContoller {

	@Resource(name = "memberDao")
	private MemberDao memberDao;

	//회원가입
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public ModelAndView join() {

		return new ModelAndView("member/join", "join", new Member());
	}

	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String join(@ModelAttribute(value = "join") Member member) {

		int ret = memberDao.joinMember(member);

		if (ret > 0) {
			System.out.println("가입성공");
		} else {
			System.out.println("가입실패");
		}

		return "redirect:index.do";
	}

	//로그인
	@RequestMapping(value = "/loginMember.do", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("member/login", "login", new Member());
	}
	
	@RequestMapping(value = "/loginMember.do", method = RequestMethod.POST)
	public String login(@ModelAttribute(value="login") Member member, HttpSession session) {
		
		Member login_mem = memberDao.loginMember(member);
		
		if(login_mem == null){
			System.out.println("로그인 안됨");
			return "redirect:loginMember.do";
		}else{
			System.out.println("로그인 됨");
			session.setAttribute("login_mem", login_mem);
			return "redirect:index.do";
		}
	}
	
	//로그아웃
	@RequestMapping(value = "/logoutMember.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("login_mem", null);
		return "index";
	}
}