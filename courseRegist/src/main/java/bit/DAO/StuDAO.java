package bit.DAO;

import bit.beans.Course;
import bit.beans.CourseRegist;
import bit.beans.Student;
import bit.mapper.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StuDAO {
    @Autowired
    private StuMapper stuMapper;

    public Student getLoginStu(Student loginBean){
        return stuMapper.getLoginStu(loginBean);
    }

    public int insertCourseRegist(CourseRegist crBean){
        return stuMapper.insertCourseRegist(crBean);
    }

    public int deleteCourseRegist(CourseRegist crBean){
        return stuMapper.deleteCourseRegist(crBean);
    }

    public List<Course> getMylist(int stu_num){
        return stuMapper.getMylist(stu_num);
    }

    public List<Course> getSubList(int stu_num){
        return stuMapper.getSubList(stu_num);
    }

    public void addRegist(int cs_num){
        stuMapper.addRegist(cs_num);
    }

    public void removeRegist(int cs_num){
        stuMapper.removeRegist(cs_num);
    }

    public Course getRegist(int cs_num){
        return stuMapper.getRegist(cs_num);
    }
}
