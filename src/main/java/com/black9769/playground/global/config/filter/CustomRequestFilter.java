package com.black9769.playground.global.config.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class CustomRequestFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CustomRequestFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
        log.info("CustomRequestFilter 요청을 보냄");
        log.info(request.toString());
    }

    @Override
    public void destroy(){
        log.info("CustomRequestFilter destroy");
    }

}
