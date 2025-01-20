package kr.bit.mapper;

import kr.bit.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member memberDoubleCheck(String memberID);
    int register(Member member); //가입성공 1, 실패0
    Member getLogibMember(Member loginMemberBean);
    int memberUpdate(Member member);
}
