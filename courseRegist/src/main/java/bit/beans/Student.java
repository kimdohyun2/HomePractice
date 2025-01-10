package bit.beans;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Student {
    private int stu_num;

    @Size(min=4, max=10)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String stu_id;

    @Size(min=4, max=10)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String stu_pw;

    @Size(min=4, max=10)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String stu_pw2;

    private boolean existId; //중복확인
    private boolean stuLogin; // 로그인 세션 관리

    public Student() {
        existId = false;
        stuLogin = false;
    }
}
