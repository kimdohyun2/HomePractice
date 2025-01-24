package kr.bit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.bit.entity.Member;
import kr.bit.service.BoardService;

@Controller
@RequestMapping("/login/*")
public class LoginController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/loginPro")
	public String login(Member vo, HttpSession session) {
		Member mem=boardService.login(vo);
		if(mem!=null) { 
			session.setAttribute("mem", mem); 
		}
		return "redirect:/board/list";
	}

	@RequestMapping("/logoutPro")
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "redirect:/board/list";
	}
}
