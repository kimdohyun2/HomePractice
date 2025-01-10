package bit.beans;

import lombok.Data;

@Data
public class Course {
    private int cs_num;
    private String cs_name;
    private int credit;
    private int max_regi;
    private int cur_regi;
    private String cs_day;
    private String cs_time;
}
