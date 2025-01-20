package kr.bit.entity;

import lombok.Data;

@Data
public class Board {
    private int idx;
    private String memberID;
    private String title;
    private String content;
    private String writer;
    private String indate;
    private int count;
}
