package bit.interceptor;

import bit.beans.Student;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuInterceptor implements HandlerInterceptor {

    private Student loginBean;

    public StuInterceptor(Student loginBean){
        this.loginBean=loginBean;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(loginBean.isStuLogin()==false){
            String str=request.getContextPath();

            response.sendRedirect(str+"/not_login"); //로그인 안되어있음 이 주소로 강제이동시킴
            return false;
        }
        return true;
    }
}
