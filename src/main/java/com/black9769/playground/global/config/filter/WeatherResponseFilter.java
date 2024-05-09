package com.black9769.playground.global.config.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
public class WeatherResponseFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필요한 경우 초기화 코드 작성
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // HttpServletResponseWrapper를 사용하여 응답 데이터를 가로챔
        ModifyResponseWrapper wrappedResponse = new ModifyResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, wrappedResponse);

        // 가로챈 응답 데이터를 수정하여 클라이언트로 전송
        byte[] modifiedResponseData = modifyResponseData(wrappedResponse.getData());
        response.getOutputStream().write(modifiedResponseData);
    }

    @Override
    public void destroy() {
        // 필요한 경우 정리 코드 작성
    }

    private byte[] modifyResponseData(byte[] responseData) {
        // HTTP 응답 데이터를 문자열로 변환
        String responseContent = new String(responseData);

        // "Seoul"을 "서울"로 변경
        String modifiedResponseContent = responseContent.replace("\"name\":\"Seoul\"", "\"name\":\"서울\"");

        // 변경된 문자열을 다시 바이트 배열로 변환하여 반환
        return modifiedResponseContent.getBytes();
    }

    private static class ModifyResponseWrapper extends HttpServletResponseWrapper {
        private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        public ModifyResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new ServletOutputStream() {
                @Override
                public void write(int b) throws IOException {
                    buffer.write(b);
                }

                @Override
                public void flush() throws IOException {
                    buffer.flush();
                }

                @Override
                public boolean isReady() {
                    return true; // 비동기 출력을 지원하는 경우에만 false를 반환하도록 구현
                }

                @Override
                public void setWriteListener(WriteListener writeListener) {

                }
            };
        }

        public byte[] getData() {
            return buffer.toByteArray();
        }
    }

}
