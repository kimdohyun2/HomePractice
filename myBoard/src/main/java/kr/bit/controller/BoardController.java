package kr.bit.controller;


import kr.bit.beans.Content;
import kr.bit.beans.Page;
import kr.bit.beans.User;
import kr.bit.service.BoardService;
import kr.bit.service.TopMenuService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private TopMenuService topMenuService;

    @Autowired
    private BoardService boardService;

    @Resource(name="loginBean")
    private User loginBean;

    @GetMapping("/main")
    public String main(@RequestParam("board_info_idx") int board_info_idx,
                       @RequestParam("page") int page, Model model){

        String boardName=boardService.getBoardInfoName(board_info_idx); //board_info_name추출 메소드
        model.addAttribute("boardName",boardName);

        model.addAttribute("board_info_idx",board_info_idx);
        model.addAttribute("page", page);

        List<Content> contentList = boardService.getContent(board_info_idx, page);
        model.addAttribute("contentList",contentList);

        Page pageBean = boardService.getCnt(board_info_idx, page);
        model.addAttribute("pBean",pageBean);

        return "board/main";
    }

    @GetMapping("/write")
    public String write(@ModelAttribute("writeBean") Content writeBean,
                        @RequestParam("board_info_idx") int board_info_idx){

        writeBean.setContent_board_idx(board_info_idx); //1, 게시판

        return "board/write";

    }
    @PostMapping("/write_pro") //입력한 제목,내용을 Content필드에 주입
    public String write_pro(@Valid @ModelAttribute("writeBean") Content writeBean,
                            BindingResult result){
        if(result.hasErrors()){
            return "board/write";
        }
        boardService.addContent(writeBean); //작성하기 누르면 db에 삽입(글제목, 내용)
        return "board/write_success";
    }

    @GetMapping("/read")
    public String read(@RequestParam("content_idx") int content_idx,
                       @RequestParam("page") int page, Model model){
        Content readContent=boardService.getInfo(content_idx);

        model.addAttribute("page",page);
        model.addAttribute("readContent",readContent);
        model.addAttribute("loginBean",loginBean);

        return "board/read";
    }

    @GetMapping("/not_writer")
    public String not_writer(){
        return "board/not_writer";
    }

    @GetMapping("/modify")
    public String modify(@ModelAttribute("modifyBean") Content modifyBean,
                         @RequestParam("content_idx") int content_idx,
                         @RequestParam("page") int page,
                         Model model){
        model.addAttribute("page",page);

        //수정할 글정보(글쓴이, 제목, 내용)...를 가져와서 업데이트 시킨 후 뿌린다
        //수정하려는 게시글 정보를 db에서 가져와서
        Content temp=boardService.getInfo(content_idx);

        //게시글정보를 Content에 담아서 modify.jsp로 이동
        modifyBean.setContent_idx(temp.getContent_idx());
        modifyBean.setContent_subject(temp.getContent_subject());
        modifyBean.setContent_text(temp.getContent_text());
        modifyBean.setContent_writer_name(temp.getContent_writer_name());
        modifyBean.setContent_date(temp.getContent_date());
        modifyBean.setContent_writer_idx(temp.getContent_writer_idx());
        modifyBean.setContent_board_idx(temp.getContent_board_idx());

        return "board/modify";
    }

    @PostMapping("modify_pro")
    public String modify_pro(@Valid @ModelAttribute("modifyBean") Content modifyBean,
                             BindingResult result,
                             @RequestParam("page") int page, Model model){
        if(result.hasErrors()){
            return "board/modify";
        }
        boardService.updateContent(modifyBean);
        model.addAttribute("modifyBean",modifyBean);
        model.addAttribute("page", page);
        return "board/modify_success";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("content_idx") int content_idx,
                         @RequestParam("board_info_idx") int board_info_idx,
                         @RequestParam("page") int page, Model model){
        boardService.deleteContent(content_idx);
        model.addAttribute("board_info_idx",board_info_idx);
        model.addAttribute("page", page);
        return "board/delete";
    }
}
