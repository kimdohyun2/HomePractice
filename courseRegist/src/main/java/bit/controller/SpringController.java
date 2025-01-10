package bit.controller;

import bit.beans.Course;
import bit.beans.CourseRegist;
import bit.beans.Student;
import bit.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.validation.Valid;
import java.util.List;

@Controller
public class SpringController {
    @Resource(name="loginBean")
    private Student loginBean;

    @Autowired
    private StuService stuService;

    @GetMapping("/login")
    public String login(@ModelAttribute("loginProBean") Student loginProBean, Model model,
                        @RequestParam(value="fail", defaultValue = "false") boolean fail){

        model.addAttribute("fail",fail);
        if(loginBean.isStuLogin()){
            return "redirect:/menu";
        }
        return "/login";
    }

    @PostMapping("/login_pro")
    public String login_pro(@Valid @ModelAttribute("loginProBean") Student loginProBean,
                            BindingResult result, Model model){
        if(result.hasErrors()){
            return "/login";
        }
        stuService.getLoginStu(loginProBean);

        if(loginBean.isStuLogin()){
            return "redirect:/menu";
        }
        else{
            return "redirect:/login?fail=true";
        }
    }

    @GetMapping("logout")
    public String logout(){
        loginBean.setStuLogin(false);
        return "/logout";
    }

    @GetMapping("/not_login")
    public String not_login(){
        return "/not_login";
    }

    @GetMapping("menu")
    public String menu(Model model){
        List<Course> subList = stuService.getSubList(loginBean.getStu_num());
        List<Course> mySublist = stuService.getMylist(loginBean.getStu_num());
        model.addAttribute("subList", subList);
        model.addAttribute("mySublist", mySublist);
        return "/menu";
    }

    @GetMapping("regist_pro")
    public String regist_pro(@RequestParam("cs_num") int cs_num, Model model){
        CourseRegist courseRegist = new CourseRegist();
        courseRegist.setCs_num(cs_num);
        courseRegist.setStu_num(loginBean.getStu_num());

        model.addAttribute("suc", stuService.insertCourseRegist(courseRegist));
        return "/regist_result";
    }

    @GetMapping("delete_pro")
    public String delete_pro(@RequestParam("cs_num") int cs_num, Model model){
        CourseRegist courseRegist = new CourseRegist();
        courseRegist.setCs_num(cs_num);
        courseRegist.setStu_num(loginBean.getStu_num());

        model.addAttribute("suc", stuService.deleteCourseRegist(courseRegist));
        return "/delete_result";
    }
}
