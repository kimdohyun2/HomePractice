package kr.bit.service;

import kr.bit.beans.BoardInfo;
import kr.bit.dao.TopMenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopMenuService {

    @Autowired
    private TopMenuDao topMenuDao;

    public List<BoardInfo> getTopMenu(){
        return topMenuDao.getTopMenu();
    }
    //상단메뉴에 '게시판' 띄우고 싶음(상단메뉴는 어떤 주소로 들어가도 출력되기 때문에 -
    //뭘 요청하던간에 topmenu를 통과해야한다

}
