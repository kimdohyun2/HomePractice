package kr.bit.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
public class MemberUser extends User {
    private Member member;

    public MemberUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MemberUser(Member member) {
        super(member.getMemberID(), member.getMemberPw(), member.getAuthList().stream()
                .map(auth->new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
        this.member = member;
    }
    //Auth("ROLE_USER") > "ROLE_USER" > SimpleGrantedAuthority("ROLE_USER")
    //사용자 권한 리스트를 > simpleGrantedAuthority 객체로 변환함
    //시큐리티에서 권한 정보를 GrantedAuthority 인터페이스로 다루기  때문에
    //디비에 있는 권한정보를 SimpleGrantedAuthority 로 변환해줘야 함

    /*public MemberUser(Member member) {
        super(member.getMemberID(), member.getMemberPw(), member.getAuthList());
    }*/
}
