package com.my.gyun.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.gyun.Service.BoardService;
import com.my.gyun.VO.Board;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String board() {
		return "board";
	}
	@RequestMapping(value="/getBoards", method = RequestMethod.GET)
    public List<Board> getBoards() {
        return boardService.list();
    }
	
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public String write() {
			
		return "write";
	}
	
	@RequestMapping(value="/writeForm")
	public String writeForm(@ModelAttribute Board board) {
		board.setRegDate(new Date());
		boardService.write(board);
		return "redirect:/";
	}
	
	@RequestMapping(value="/detail/{seq}")
	public String detail(@PathVariable int seq, Model model) {
		Board board = boardService.findBySeq(seq);
		model.addAttribute("board", board);
		return "detail";
	}
	@RequestMapping(value="/detail/{seq}/update")
	public String update(@PathVariable int seq, @ModelAttribute Board board, Model model) {
		board = boardService.findBySeq(seq);
		model.addAttribute("board", board);
		return "update";
	}
	
	@RequestMapping(value="/detail/{seq}/updateForm")
	public String updateForm(@PathVariable int seq, @RequestParam String content, @RequestParam String title) {
	    Board board = new Board();
	    board.setSeq(seq);
	    board.setContent(content);
	    board.setTitle(title);

	    boardService.update(board);
		return "redirect:/detail/{seq}";
	}
	
	@RequestMapping(value="/detail/{seq}/delete")
	public String delete(@PathVariable int seq) {
		boardService.delete(seq);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/detail/returnBoard")
	public String returnBoard() {
		return "redirect:/";
	}
}
