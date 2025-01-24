package kr.bit.mapper;

import java.util.List;

import kr.bit.entity.Board;
import kr.bit.entity.Criteria;
import kr.bit.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	
	public List<Board> getList(Criteria cri); //보드 리스트 검색해서 가져옴
	public void insert(Board vo);
	public void insertSelectKey(Board vo); //보드 추가
	public Member login(Member vo); //로그인
	public Board read(int idx); //보드 객체 1개 가져옴
	public void update(Board vo); //보드 수정
	public void delete(int idx); //보드 삭제
	public void replyUpdate(Board pa); //리플단 글의 자식글 우선순위를 하나씩 증가시킴
	public void replyInsert(Board vo); //
	public int totalCount(Criteria cri);
	public void cntUpdate(int idx);

}
