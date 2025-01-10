package bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //클라이언트의 요청 처리, 뷰 반환
public class HomeController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home(){
        return "forward:/login";
    }
}
