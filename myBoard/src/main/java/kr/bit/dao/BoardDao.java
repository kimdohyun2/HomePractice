package kr.bit.dao;

import kr.bit.beans.Content;
import kr.bit.mapper.BoardMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    @Autowired
    private BoardMapper boardMapper;

    public void addContent(Content writeContentBean){
        boardMapper.addContent(writeContentBean);
    }

    public String getBoardInfoName(int board_info_idx){
        return boardMapper.getBoardInfoName(board_info_idx);
    }

    //RowBounds : mybatis에서 제공하는 페이징 처리 도구
    //offset(시작위치), limit(조회할 데이터 수)
    //RowBounds rowBounds = new RowBounds(0,5);
    public List<Content> getContent(int board_info_idx, RowBounds rowBounds){
        return boardMapper.getContent(board_info_idx, rowBounds);
    }

    public Content getInfo(int content_idx){
        return boardMapper.getInfo(content_idx);
    }

    public void deleteContent(int content_idx){
        boardMapper.deleteContent(content_idx);
    }

    public void updateContent(Content modifyBean){
        boardMapper.updateContent(modifyBean);
    }

    public int getCnt(int content_board_idx){
        return boardMapper.getCnt(content_board_idx);
    }
}
