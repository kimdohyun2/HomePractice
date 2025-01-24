package kr.bit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import kr.bit.entity.Board;
import kr.bit.entity.Criteria;
import kr.bit.entity.Member;
import kr.bit.mapper.BoardMapper;

@Service
@Primary
public class BoardServiceImpl implements BoardService {
	// Implementation details...

	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<Board> getList(Criteria cri) {
		List<Board> li=boardMapper.getList(cri); //xml 쿼리문 실행
		return li;
	}

	@Override
	public Member login(Member vo) {
		Member mem=boardMapper.login(vo);
		return mem;
	}

	@Override
	public void register(Board vo) {
		boardMapper.insertSelectKey(vo);
		
	}

	@Override
	public Board get(int idx) {
		Board vo=boardMapper.read(idx);
		boardMapper.cntUpdate(idx);
		return vo;
	}


	@Override
	public void modify(Board vo) {
		boardMapper.update(vo);
		
	}

	@Override
	public void remove(int idx) {
		boardMapper.delete(idx);
		
	}

	@Override
	public void replyPro(Board vo) {
		//답글만들기
		//부모글의 정보를 가져온다
		Board pa=boardMapper.read(vo.getIdx());
		//부모글의 boGroup값을 -> 답글 정보에 저장
		vo.setBoGroup(pa.getBoGroup());
		
		//부모글의 boSequence값에 1을 더해서 -> 답글 정보에 저장
		vo.setBoSequence(pa.getBoSequence()+1);
		//부모글의 boLevel값에 1을 더해서 -> 답글 정보에 저장
		vo.setBoLevel(pa.getBoLevel()+1);
		
		boardMapper.replyUpdate(pa);
		//답글저장
		boardMapper.replyInsert(vo);
		
		
	}

	@Override
	public int totalCount(Criteria cri) {
		return boardMapper.totalCount(cri);
	}


	
}






