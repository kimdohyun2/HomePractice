package bit.service;

import bit.DAO.StuDAO;
import bit.beans.CourseRegist;
import bit.beans.Student;
import bit.mapper.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import bit.beans.Course;

@Service
public class StuService {
    @Resource(name = "loginBean")
    private Student loginBean;

    @Autowired
    private StuDAO stuDAO;

    public void getLoginStu(Student loginProBean){
        Student loginSuccess = stuDAO.getLoginStu(loginProBean);
        if(loginSuccess!=null){
            loginBean.setStu_num(loginSuccess.getStu_num());
            loginBean.setStuLogin(true);  //로그인이 되어있는 상태이므로 true
        }
    }

    public boolean insertCourseRegist(CourseRegist crBean){
        Course temp = stuDAO.getRegist(crBean.getCs_num());
        if(temp.getCur_regi() < temp.getMax_regi()){
            if(stuDAO.insertCourseRegist(crBean) > 0){
                stuDAO.addRegist(crBean.getCs_num());
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean deleteCourseRegist(CourseRegist crBean){
        if(stuDAO.deleteCourseRegist(crBean) > 0){
            stuDAO.removeRegist(crBean.getCs_num());
            return true;
        }else{
            return false;
        }
    }

    public List<Course> getMylist(int stu_num){
        return stuDAO.getMylist(stu_num);
    }

    public List<Course> getSubList(int stu_num) {
        return stuDAO.getSubList(stu_num);
    }
}
