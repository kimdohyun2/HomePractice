package kr.bit.entity;

import lombok.Data;

import java.util.List;

@Data
public class Member {
    private int memberIdx;
    private String memberID;
    private String memberPw;
    private String memberName;
    private int memberAge;
    private String memberGender;
    private String memberEmail;
    private String memberProfile;
    private List<MemberAuth> authList;
}