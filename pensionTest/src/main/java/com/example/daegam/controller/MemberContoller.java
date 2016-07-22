package com.example.daegam.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.daegam.dao.MemberDao;
import com.example.daegam.vo.Member;

@Controller
public class MemberContoller {

	@Resource(name = "memberDao")
	private MemberDao memberDao;

	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public ModelAndView join() {

		return new ModelAndView("join", "join", new Member());
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

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {

		return "login";
	}
}