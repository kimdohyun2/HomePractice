package bit.config;


import bit.beans.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.*;
import bit.interceptor.StuInterceptor;

import javax.annotation.Resource;

@Configuration
@EnableWebMvc
@PropertySource("/WEB-INF/properties/db.properties")
@ComponentScan("bit.controller")
public class ServletAppContext implements WebMvcConfigurer {
    @Resource(name = "loginBean")
    private Student loginBean;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        WebMvcConfigurer.super.configureViewResolvers(registry);
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }

    public void addInterceptors(InterceptorRegistry registry){
        WebMvcConfigurer.super.addInterceptors(registry);

        StuInterceptor stuInterceptor = new StuInterceptor(loginBean);
        InterceptorRegistration re1=registry.addInterceptor(stuInterceptor);
        re1.addPathPatterns("/**");  //모든경로로 매핑해도 다 뜨도록 ..컨트롤러 전에 preHandle
        re1.excludePathPatterns("/","/login_pro","/login","/not_login");
    }
}
