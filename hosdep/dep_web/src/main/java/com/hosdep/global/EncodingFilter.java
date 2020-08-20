package com.hosdep.global;

import javax.servlet.*;
import java.io.IOException;

/**
 * 编码过滤器，防止中文乱码
 */
public class EncodingFilter implements Filter {

    //设置初始化编码
    private String encoding = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (filterConfig.getInitParameter("ENCODING") != null) {
            encoding = filterConfig.getInitParameter("ENCODING");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        encoding = null;
    }
}
