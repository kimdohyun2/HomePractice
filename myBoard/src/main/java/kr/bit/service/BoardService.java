package kr.bit.service;

import kr.bit.beans.Content;
import kr.bit.beans.Page;
import kr.bit.beans.User;
import kr.bit.dao.BoardDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
    @Value("${page.listcount}")
    private int page_listcount;

    @Value("${page.pa}")
    private int page_pa;

    @Autowired
    private BoardDao boardDao;

    @Resource(name="loginBean")
    private User loginBean;

    public void addContent(Content writeContentBean){
        //로그인한 사람의 idx값 가져와 글작성자 idx값에 세팅
        writeContentBean.setContent_writer_idx(loginBean.getUser_idx());
        boardDao.addContent(writeContentBean);
    }

    public String getBoardInfoName(int board_info_idx){
        return boardDao.getBoardInfoName(board_info_idx);
    }

    public List<Content> getContent(int board_info_idx, int page){
        int offset = (page - 1) * page_listcount;

        return boardDao.getContent(board_info_idx,new RowBounds(offset,page_listcount));
    }

    public Content getInfo(int content_idx){
        return boardDao.getInfo(content_idx);
    }

    public void deleteContent(int content_idx){
        boardDao.deleteContent(content_idx);
    }

    public void updateContent(Content modifyBean){
        boardDao.updateContent(modifyBean);
    }

    public Page getCnt(int board_info_idx, int currentPage){
        int content_cnt = boardDao.getCnt(board_info_idx);

        Page page = new Page(content_cnt, currentPage, page_listcount, page_pa);

        return page;
    }
}
