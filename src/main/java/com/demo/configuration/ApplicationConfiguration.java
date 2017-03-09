package com.demo.configuration;

import com.demo.web.MyOpenSessionFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 海峰 on 2017/3/9.
 */
@Configuration
@Slf4j
public class ApplicationConfiguration {

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyOpenSessionFilter());
        registration.addUrlPatterns("/myFilter");
        registration.addInitParameter("filter", "openSessionFilter");
        registration.setName("openSessionFilter");
        registration.setOrder(1);
        log.info("=======================配置自定义过滤器=========================");
        return registration;
    }
}
