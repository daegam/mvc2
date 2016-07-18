package com.example.daegam;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.daegam.dao.BoardDao;
import com.example.daegam.vo.Board;

@Controller
public class BoardController {

	@Resource(name = "boardDao")
	private BoardDao boardDao;

	@RequestMapping(value = "/boardwrite", method = RequestMethod.GET)
	public ModelAndView boardWrite() {

		return new ModelAndView("boardwrite", "boardwrite", new Board());
	}

	@RequestMapping(value = "/boardwrite.do", method = RequestMethod.POST)
	public String boardWrite1(@ModelAttribute("boardwrite") Board board) {

		boardDao.boardWrite(board);
		return "redirect:boardlist";
	}

	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)
	public String boardList(Model model,
			@RequestParam(value = "search_type", required = false, defaultValue = "") String search_type,
			@RequestParam(value = "search_text", required = false, defaultValue = "") String search_text) {

		List<Board> arr_board = boardDao.getBoardList();
		model.addAttribute("arr_board", arr_board);

		return "boardlist";
	}

	@RequestMapping(value = "/boardContent", method = RequestMethod.GET)
	public String BoardContent(Model model, @RequestParam("no") int no) {

		Board board = boardDao.getBoardContent(no);

		model.addAttribute("_board", board);

		return "boardcontent";
	}

	@RequestMapping(value = "/boardupdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(Model model, @RequestParam("no") int no) {

		Board board = boardDao.getBoardContent(no);

		return new ModelAndView("boardupdate", "boardupdate", board);
	}

	@RequestMapping(value = "/boardupdate.do", method = RequestMethod.POST)
	public String boardUpdate1(@ModelAttribute("boardupdate") Board board) {

		boardDao.boardUpdate(board);

		return "redirect:boardlist";
	}

	@RequestMapping(value = "/boarddelete.do", method = RequestMethod.GET)
	public String boardDelete(@RequestParam("no") int no) {
		
		boardDao.boardDelete(no);
		
		return "redirect:boardlist";
	}
}