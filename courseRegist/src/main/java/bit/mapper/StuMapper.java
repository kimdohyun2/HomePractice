package bit.mapper;

import bit.beans.Course;
import bit.beans.CourseRegist;
import bit.beans.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StuMapper {
    @Select("select stu_num, stu_id, stu_pw from student where stu_id = #{stu_id} and stu_pw = #{stu_pw}")
    Student getLoginStu(Student loginBean);

    @Insert("insert into course_regist(stu_num, cs_num) values(#{stu_num},#{cs_num})")
    int insertCourseRegist(CourseRegist crBean);

    @Delete("delete from course_regist where stu_num=#{stu_num} and cs_num=#{cs_num}")
    int deleteCourseRegist(CourseRegist crBean);

    @Select("select cs_num, cs_name, credit, max_regi, cur_regi, cs_day, cs_time  " +
            "from course co natural join course_regist cr " +
            "where stu_num = #{stu_num} order by cs_num")
    List<Course> getMylist(@Param("stu_num") int stu_num);

    @Select("SELECT cs_num, cs_name, credit, max_regi, cur_regi, cs_day, cs_time FROM course WHERE cs_num NOT IN (SELECT c.cs_num FROM course c JOIN course_regist cr USING(cs_num) WHERE stu_num = #{stu_num})")
    List<Course> getSubList(int stu_num);

    @Update("update course set cur_regi=cur_regi+1 where cs_num=#{cs_num}")
    void addRegist(int cs_num);

    @Update("update course set cur_regi=cur_regi-1 where cs_num=#{cs_num}")
    void removeRegist(int cs_num);

    @Select("select cur_regi, max_regi from course where cs_num=#{cs_num}")
    Course getRegist(int cs_num);
}
