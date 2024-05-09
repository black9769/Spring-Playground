package com.black9769.playground.global.config.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@Slf4j
@WebFilter(urlPatterns = "/api.openweathermap.org/data/2.5/weather/*")
public class CustomResponseFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CustomResponseFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
        log.info("CustomResponseFilter doFilter");
    }

    @Override
    public void destroy(){
        log.info("CustomResponseFilter destroy");
    }

}
