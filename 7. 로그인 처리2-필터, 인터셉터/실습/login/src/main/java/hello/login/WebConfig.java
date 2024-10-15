package hello.login;

import hello.login.web.filter.LogFilter;
import hello.login.web.filter.LoginCheckFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebConfig {

    // 로그 필터
    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean();
        // 등록할 필터를 지정함
        filterRegistrationBean.setFilter(new LogFilter());
        // 필터는 체인으로 동작함. 따라서 순서가 필요함. 낮을수록 먼저 동작함.
        filterRegistrationBean.setOrder(1);
        // 필터를 적용할 URL 패턴을 지정함. 한번에 여러 패턴을 지정할 수 있음.
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    // 로그인 체크 필터
    @Bean
    public FilterRegistrationBean loginCheckFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        // 로그인 필터 등록
        filterFilterRegistrationBean.setFilter(new LoginCheckFilter());
        // 로그 필터에 이어서 두번째로
        filterFilterRegistrationBean.setOrder(2);
        // 모든 요청에 로그인 필터 적용x
        filterFilterRegistrationBean.addUrlPatterns("/*");
        return filterFilterRegistrationBean;
    }
}
