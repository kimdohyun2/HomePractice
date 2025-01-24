package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.bit.entity.Board;
import kr.bit.entity.Criteria;
import kr.bit.entity.PageCre;
import kr.bit.service.BoardService;
import lombok.extern.log4j.Log4j;

@Controller 
@RequestMapping("/board/*")
public class BoardController {
	@RequestMapping("/map")
	public String list(Model model) {
		return "board/maptest";
	}

	@Autowired
//	@Qualifier("BoardServiceImpl")
	BoardService boardService;

	@RequestMapping("/list")
	public String getList(Criteria cri, Model model) { // type, keyword
		List<Board> list=boardService.getList(cri);
		
		model.addAttribute("list", list); // Model
		PageCre pageCre=new PageCre();
		pageCre.setCri(cri);
		pageCre.setTotalCount(boardService.totalCount(cri));
		model.addAttribute("pageCre", pageCre);
		System.out.println(pageCre+"\n\n\n\n\n\n\n\n");
		return "board/list"; // View
 	}
	@GetMapping("/register")
	public String register() {
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(Board vo, RedirectAttributes rttr) { 
		boardService.register(vo);
		rttr.addFlashAttribute("result", vo.getIdx()); 
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public String get(@RequestParam("idx") int idx, Model model,@ModelAttribute("cri") Criteria cri) {
		Board vo=boardService.get(idx);
		model.addAttribute("vo", vo);
		return "board/get"; 
	}
	@GetMapping("/modify")
	public String modify(@RequestParam("idx") int idx, Model model,@ModelAttribute("cri") Criteria cri) {
		Board vo=boardService.get(idx);
		model.addAttribute("vo", vo);
		return "board/modify"; 
	}
	@PostMapping("/modify")
	public String modify(Board vo, Criteria cri , RedirectAttributes rttr) {
		boardService.modify(vo); //수정	
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list"; 
	}
	@GetMapping("/remove")
	public String remove(int idx, Criteria cri, RedirectAttributes rttr) {
		boardService.remove(idx);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	@GetMapping("/reply")
	public String reply(int idx, Model model, @ModelAttribute("cri") Criteria cri) {
		Board vo=boardService.get(idx);
		model.addAttribute("vo", vo);
		return "board/reply"; 
	}
	@PostMapping("/reply")
	public String reply(Board vo, Criteria cri, RedirectAttributes rttr) {
		boardService.replyPro(vo);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
}
