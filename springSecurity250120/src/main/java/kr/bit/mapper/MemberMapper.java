package kr.bit.mapper;

import kr.bit.entity.Member;
import kr.bit.entity.MemberAuth;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member memberDoubleCheck(String memberID);
    int register(Member member); //가입성공 1, 실패0
    Member getLoginMember(Member loginMemberBean);
    int memberUpdate(Member member);
    int authRegister(MemberAuth memberAuth);
}
