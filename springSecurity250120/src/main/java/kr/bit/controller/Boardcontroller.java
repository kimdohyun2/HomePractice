package kr.bit.controller;

import kr.bit.mapper.BoardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Boardcontroller {
    @Autowired
    BoardMapper boardMapper;

    private static final Logger logger = LoggerFactory.getLogger(Boardcontroller.class);

    @RequestMapping("board/main")
    public String boardmain(Model model) {
        return "board/main";
    }
}
