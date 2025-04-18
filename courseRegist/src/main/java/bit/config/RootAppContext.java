package bit.config;

import bit.beans.Student;
import bit.mapper.StuMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
@ComponentScan("bit.DAO")
@ComponentScan("bit.service")
@PropertySource("/WEB-INF/properties/db.properties")
public class RootAppContext { //root-context.xml 역할
    @Bean("loginBean")
    @SessionScope
    public Student loginBean(){
        return new Student();
    }

    @Value("${db.classname}")
    private String db_classname;

    @Value("${db.url}")
    private String db_url;

    @Value("${db.username}")
    private String db_username;

    @Value("${db.password}")
    private String db_password;

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName(db_classname);
        source.setUrl(db_url);
        source.setUsername(db_username);
        source.setPassword(db_password);

        return source;
    }

    @Bean
    public SqlSessionFactory factory(BasicDataSource source) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(source);

        SqlSessionFactory factory = factoryBean.getObject();
        return factory;  //sql실행, 매핑 인터페이스 처리
    }

    @Bean
    public MapperFactoryBean<StuMapper> stu_mapper(SqlSessionFactory factory) throws Exception{
        MapperFactoryBean<StuMapper> fac=
                new MapperFactoryBean<StuMapper>(StuMapper.class);

        fac.setSqlSessionFactory(factory);
        return fac;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
    //properties파일에 있는 값을 뷰에 출력하기 위해서
    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource res=new ReloadableResourceBundleMessageSource();
        //res.setDefaultEncoding("UTF-8");
        res.setBasenames("/WEB-INF/properties/error");
        return res;
    }
}
