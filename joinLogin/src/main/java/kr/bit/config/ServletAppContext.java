package kr.bit.config;


import kr.bit.beans.User;
import kr.bit.interceptor.LoginInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

@Configuration
@EnableWebMvc
@ComponentScan("kr.bit.controller")

public class ServletAppContext implements WebMvcConfigurer {
    @Resource(name="loginBean")
    private User loginBean;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        WebMvcConfigurer.super.configureViewResolvers(registry);
        registry.jsp("/WEB-INF/views/",".jsp");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }

    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);

        LoginInterceptor topMenuInterceptor = new LoginInterceptor(loginBean);
        InterceptorRegistration re1=registry.addInterceptor(topMenuInterceptor);
        re1.addPathPatterns("/main","/logout");

//        LoginInterceptor loginInterceptor = new LoginInterceptor(loginBean);
//        InterceptorRegistration re2=registry.addInterceptor(loginInterceptor);
//        re2.addPathPatterns("/user/modify","/user/logout","/board/*");
//        re2.excludePathPatterns("/board/main");
//        //이 주소로 들어가기 전에 로그인 여부를 알아내서 로그인이 안되어있다면 user/not_login으로 강제이동
//
//        WriterInterceptor writerInterceptor = new WriterInterceptor(loginBean, boardService);
//        InterceptorRegistration re3=registry.addInterceptor(writerInterceptor);
//        re3.addPathPatterns("/board/modify","/board/delete");
    }
}





