package kr.bit.config;


import kr.bit.security.MemberUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new MemberUserDetailsService();
    }

    @Override //시큐리티 인증 설정하는 객체
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder()); //비밀번호 암호화하여 인증 수행
    }

    //인증, 보안필터 설정 가능해짐
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //요청에 대한 보안 설정
        CharacterEncodingFilter filter=new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);
        //csrf보안 처리 전에 실행되도록

        //요청에 따른 권한 확인 후 서비스 하는 코드
        http
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/member/login")
                .loginProcessingUrl("/member/loginPro") //로그인 처리 페이지
                .permitAll() //로그인 페이지는 누구나 접근 가능
                .and()
                .logout()
                .logoutUrl("/member/logout")
                .invalidateHttpSession(true) //로그아웃 후 세션 제거
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/denied"); //권한 부족시 denied로 이동
    }

    //패스워드 인코딩 객체-> 패스워드 암호화
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
