package com.LiHongxin.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LHXFilter")
public class LiHongxinFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("LiHongxinFilter -- before chain");
        chain.doFilter(req, resp);
        System.out.println("LiHongxinFilter -- after chain");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
