package com.example.daegam;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.daegam.dao.CommonDao;
import com.example.daegam.vo.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource(name = "objDao")
	private CommonDao objDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {

		return "index";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Model model) {

		return "login";

	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("password") String password,
			@RequestParam("name") String name) {

		System.out.println("id : " + id);
		System.out.println("password : " + password);
		System.out.println("name : " + name);

		return "login";
	}

	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public ModelAndView login1(Locale locale, Model model) {

		Member member = new Member();

		return new ModelAndView("login1", "command", member);
	}

	@RequestMapping(value = "/login1.do", method = RequestMethod.POST)
	public String login1(@ModelAttribute("command") Member member, HttpSession session) {

		Member ret = objDao.login(member);

		if (ret != null) {
			session.setAttribute("_id", ret.getId());
			System.out.println(session.getAttribute("_id"));
			return "redirect:chat";
		} else {
			System.out.println("��ġ�ϴ� ȸ���� �����ϴ�.");
			return "redirect:login1.do";
		}
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login1.do";
	}

	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public ModelAndView join1(Locale locale, Model model) {

		Member member = new Member();
		return new ModelAndView("join", "command", member);
	}

	@RequestMapping(value = "/joinadd.do", method = RequestMethod.POST)
	public String join2(@ModelAttribute("command") Member member) {

		objDao.join(member);

		return "redirect:mlist";
	}

	@RequestMapping(value = "/mlist", method = RequestMethod.GET)
	public String mlist(Locale locale, Model model,
			@RequestParam(value = "cnt", required = false, defaultValue = "100") int cnt) {
		
		List<Member> list = objDao.getList(cnt);
		model.addAttribute("_list", list);
		return "mlist";
	}

	@RequestMapping(value = "/mupdate", method = RequestMethod.GET)
	public ModelAndView mupdate(@RequestParam("id") String id) {

		Member member = objDao.getMemberOne(id);

		return new ModelAndView("mupdate", "command", member);
	}

	@RequestMapping(value = "/mupdate.do", method = RequestMethod.POST)
	public String mupdate1(@ModelAttribute("common") Member member) {

		objDao.updateMember(member);

		return "redirect:mlist";
	}

	@RequestMapping(value = "/mdelete", method = RequestMethod.GET)
	public String mdelete(@RequestParam("id") String id) {
		objDao.mdelete(id);
		return "redirect:mlist";
	}

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String chat() {
		return "chatclient";
	}
}