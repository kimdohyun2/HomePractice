package kr.bit.config;


import kr.bit.beans.User;
import kr.bit.interceptor.LoginInterceptor;
import kr.bit.interceptor.TopMenuInterceptor;
import kr.bit.interceptor.WriterInterceptor;
import kr.bit.service.BoardService;
import kr.bit.service.TopMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

@Configuration
@EnableWebMvc
@ComponentScan("kr.bit.controller")

public class ServletAppContext implements WebMvcConfigurer {

    //로그인 여부에 따라 상단메뉴바가 다르게 보이도록 하기위해 주입받음
    @Resource(name="loginBean")
    private User loginBean;

    @Autowired
    private TopMenuService topMenuService;

    @Autowired
    private BoardService boardService;

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

    //인터셉터 등록
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);

        TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(topMenuService, loginBean);
        InterceptorRegistration re1=registry.addInterceptor(topMenuInterceptor);
        re1.addPathPatterns("/**");  //모든경로로 매핑해도 다 뜨도록 ..컨트롤러 전에 preHandle

        LoginInterceptor loginInterceptor = new LoginInterceptor(loginBean);
        InterceptorRegistration re2=registry.addInterceptor(loginInterceptor);
        re2.addPathPatterns("/user/modify","/user/logout","/board/*");
        re2.excludePathPatterns("/board/main");
        //이 주소로 들어가기 전에 로그인 여부를 알아내서 로그인이 안되어있다면 user/not_login으로 강제이동

        WriterInterceptor writerInterceptor = new WriterInterceptor(loginBean, boardService);
        InterceptorRegistration re3=registry.addInterceptor(writerInterceptor);
        re3.addPathPatterns("/board/modify","/board/delete");
    }
}





