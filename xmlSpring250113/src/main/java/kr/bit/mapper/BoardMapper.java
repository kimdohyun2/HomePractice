package kr.bit.mapper;

import kr.bit.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getLists();
    void addBoard(Board board);
    void deleteBoard(int idx);
    void updateBoard(Board board);
    void visitBoard(int idx);
    int getVisitCount(int idx);
}
