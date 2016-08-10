package com.ds201604.pension.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ds201604.pension.vo.Member;


@Controller
public class MemberController {
	
	//회원가입
	@RequestMapping(value = "/joinMember.do", method = RequestMethod.GET)
	public ModelAndView joinMember() {
		
		return new ModelAndView("member/join", "member", new Member());
	}
	
	//회원가입 DB에 넣기
	@RequestMapping(value = "/joinMember.do", method = RequestMethod.POST)
	public String joinMember(@ModelAttribute(value="member") Member member) {
		
		return "index";
	}
}