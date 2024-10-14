package hello.login;

import hello.login.web.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebConfig {

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
}
