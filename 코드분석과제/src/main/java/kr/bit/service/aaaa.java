package kr.bit.service;

import kr.bit.entity.Board;
import kr.bit.entity.Criteria;
import kr.bit.entity.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class aaaa implements BoardService {
    @Override
    public List<Board> getList(Criteria cri) {
        return new ArrayList<Board>();
    }

    @Override
    public Member login(Member vo) {
        return null;
    }

    @Override
    public void register(Board vo) {

    }

    @Override
    public Board get(int idx) {
        return null;
    }

    @Override
    public void modify(Board vo) {

    }

    @Override
    public void remove(int idx) {

    }

    @Override
    public void replyPro(Board vo) {

    }

    @Override
    public int totalCount(Criteria cri) {
        return 0;
    }
}
