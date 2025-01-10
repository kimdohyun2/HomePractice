package kr.bit.beans;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Content {

    private int content_idx;

    @NotBlank
    private String content_subject;

    @NotBlank
    private String content_text;

    private int content_writer_idx;
    private int content_board_idx;
    private String content_date;

    private String content_writer_name;
}
