package kr.bit.interceptor;

import kr.bit.beans.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    private User loginBean;

    public LoginInterceptor(User loginBean) {
        this.loginBean = loginBean;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!loginBean.isUserLogin()){
            String str=request.getContextPath();

            response.sendRedirect(str+"/not_login");
            return false;
        }
        return true;
    }
}
