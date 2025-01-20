package kr.bit.beans;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class User {
    private Integer user_idx;

    @Size(min = 4, max = 20)
    @Pattern(regexp = "[A-Za-z0-9]*")
    private String user_id;

    @Size(min = 4, max = 20)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[+_!@#$%^&*.,?]).*[A-Za-z0-9+_!@#$%^&*.,?]*$")
    private String user_pw;

    private String user_pw2;

    @Pattern(regexp = "[가-힣]*")
    @Size(min = 2, max = 10)
    private String user_name;

    @NotEmpty
    private String user_gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate user_birthday;

    @NotEmpty
    @Email
    private String user_email;

    @NotNull
    private Integer user_postcode;

    @NotEmpty
    private String user_address;

    @NotEmpty
    private String user_d_address;

    @NotNull
    private String user_hobby;

    @NotEmpty
    private String user_job;

    private boolean existId;
    private boolean userLogin;

    public User(){
        existId = true;
        userLogin = false;
    }
}
