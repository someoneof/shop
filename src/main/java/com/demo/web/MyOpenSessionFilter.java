package com.demo.web;

import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by 海峰 on 2017/3/9.
 */
/*
define a filter by yourself
 */
@WebFilter(filterName = "openSessionFilter",urlPatterns = "/myFilter")
public class MyOpenSessionFilter implements Filter {

    private final OpenSessionInViewFilter filter;

    public MyOpenSessionFilter() {
        filter = new OpenSessionInViewFilter();
        filter.setSessionFactoryBeanName("sessionFactory_soc");

    }



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filter.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filter.doFilter(request, response, chain);
    }

    @Override
    public void destroy() {
        filter.destroy();
    }

}
