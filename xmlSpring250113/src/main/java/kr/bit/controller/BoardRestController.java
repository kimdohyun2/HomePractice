package kr.bit.controller;

import kr.bit.entity.Board;
import kr.bit.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/board")
@RestController
public class BoardRestController {
    @Autowired
    BoardMapper boardMapper;

    @GetMapping("/all")
    public List<Board> boardList() {
        List<Board> list = boardMapper.getLists();
        return list;
    }

    @PostMapping("/new")
    public String boardInsert(@ModelAttribute Board vo) {
        boardMapper.addBoard(vo);

        return "insert success";
    }

    @DeleteMapping("/{idx}")
    public String boardDelete(@PathVariable("idx") int idx) {
        boardMapper.deleteBoard(idx);
        return "delete success";
    }

    @PutMapping("/{idx}")
    public int visit(@PathVariable int idx) {
        boardMapper.visitBoard(idx);
        return boardMapper.getVisitCount(idx);
    }

    @PutMapping("/update")
    public String boardUpdate(@RequestBody Board vo) {
        boardMapper.updateBoard(vo);
        return "update success";
    }

    /*@PutMapping("/visit/{idx}")
    public int visit(@PathVariable("idx") int idx) {
        boardMapper.visitBoard(idx);
        return boardMapper.getVisitCount(idx);
    }*/
}
