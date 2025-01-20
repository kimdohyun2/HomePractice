package kr.bit.beans;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class User {

    private int user_idx;

    @Size(min=2, max=4)
    @Pattern(regexp = "[가-힣]*")
    private String user_name;

    @Size(min=4, max=10)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_id;

    @Size(min=4, max=10)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw;

    @Size(min=4, max=10)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw2;

    private boolean existId;
    private boolean userLogin;

    public User(){
        this.existId=false;  //중복확인검사 안할걸로 초기화해줌 -> 중복확인검사 해야되니까!
        this.userLogin=false; //로그인 여부 -> 로그인 안되어있는 걸로 초기화
    }
}
