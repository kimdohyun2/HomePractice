package kr.bit.controller;

import kr.bit.beans.User;
import kr.bit.service.UserService;
import kr.bit.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class MainController {
    @Resource(name="loginBean")
    private User loginBean;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(@ModelAttribute("loginBean") User loginBean,
                        @RequestParam(value="fail", defaultValue = "false") boolean fail, Model model) {
        model.addAttribute("fail",fail);
        return "login";
    }

    @PostMapping("/login_pro")
    public String login_pro(@ModelAttribute("loginBean") User loginUserBean, Model model) {
        userService.loginUser(loginUserBean);
        if(!loginBean.isUserLogin()){
            model.addAttribute("fail",true);
            return "login";
        }else{
            return "redirect:/main";
        }
    }

    @GetMapping("/join")
    public String join(@ModelAttribute("joinBean") User joinBean){
        return "join";
    }

    @PostMapping("/join_pro")
    public String join_pro(@Valid @ModelAttribute("joinBean") User joinBean, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "join";
        }
        userService.joinUser(joinBean);
        return "join_success";
    }

    @GetMapping("/openExistChk")
    public String openExistChk(@RequestParam("user_id") String user_id, Model model){
        model.addAttribute("user_id",user_id);

        return "existChk";
    }

    @RequestMapping("/existChk")
    @ResponseBody
    public boolean existChk(@RequestParam("user_id") String user_id){
        return userService.existId(user_id);
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("loginBean",loginBean);
        return "main";
    }

    @GetMapping("logout")
    public String logout(){
        loginBean.setUserLogin(false);
        return "redirect:/login";
    }

    @GetMapping("not_login")
    public String notLogin(){
        return "not_login";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new UserValidator());
    }
}
