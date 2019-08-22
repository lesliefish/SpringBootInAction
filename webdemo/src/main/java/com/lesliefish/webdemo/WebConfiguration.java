package com.lesliefish.webdemo;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class WebConfiguration {

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        System.out.println("配置初始化RemoteIpFilter。。");
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistrationBean() {
        // 注册过滤器
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CustomFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("paramName", "paramValue");
        registrationBean.setName("CustomFilter");
        registrationBean.setOrder(1);

        System.out.println("配置初始化FilterRegistrationBean。。");
        return registrationBean;
    }

    WebConfiguration() {
        System.out.println("配置初始化。。");
    }

    /**
     * 自定义过滤器
     */
    public class CustomFilter implements Filter {
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            System.out.println("this is custom filter, uri : " + httpServletRequest.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void destroy() {

        }
    }
}
