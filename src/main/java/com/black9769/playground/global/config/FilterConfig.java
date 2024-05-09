package com.black9769.playground.global.config;

import com.black9769.playground.global.config.filter.CustomRequestFilter;
import com.black9769.playground.global.config.filter.CustomResponseFilter;
import com.black9769.playground.global.config.filter.WeatherResponseFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// FilterRegistrationBean을 사용하여 필터를 등록한다.
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomRequestFilter> customRequestFilter(){
        FilterRegistrationBean<CustomRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomRequestFilter());
        registrationBean.addUrlPatterns("/user/*");
        //registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<CustomResponseFilter> customResponseFilter(){
        FilterRegistrationBean<CustomResponseFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomResponseFilter());
        registrationBean.addUrlPatterns("/user/*");
        //registrationBean.setOrder(2);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<WeatherResponseFilter> weatherResponseFilter(){
        FilterRegistrationBean<WeatherResponseFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new WeatherResponseFilter());
        registrationBean.addUrlPatterns("/api/weather/*");
        //registrationBean.setOrder(2);
        return registrationBean;
    }
}
