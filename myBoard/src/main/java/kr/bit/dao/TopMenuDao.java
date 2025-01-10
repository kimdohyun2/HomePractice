package kr.bit.dao;

import kr.bit.beans.BoardInfo;
import kr.bit.mapper.TopMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//데이터 액세스(DAO) 계층 나타내는 어노테이션
public class TopMenuDao {

    @Autowired
    private TopMenuMapper topMenuMapper;

    public List<BoardInfo> getTopMenu(){
        return topMenuMapper.getTopMenu();
    }


}
