package kr.bit.security;

import kr.bit.entity.Member;
import kr.bit.entity.MemberUser;
import kr.bit.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Member member = memberMapper.getLoginMember(userName);
        // 이 회원정보들을 User객체가 UserDetails에 담는다
        // UserDefails > implements > User > extands > MemberUser
        if (member != null) {
            return new MemberUser(member);
        }else{
            throw new UsernameNotFoundException(userName + " not found");
        }
    }
}
