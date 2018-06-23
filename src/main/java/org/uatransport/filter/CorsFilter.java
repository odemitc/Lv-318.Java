
package org.uatransport.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.uatransport.config.ConfigurationUtils.getPropertyValue;

@Component
public class CorsFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(CorsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse)servletResponse;
        response.setHeader("Access-Control-Allow-Origin", getPropertyValue("Access-Control-Allow-Origin"));
        response.setHeader("Access-Control-Allow-Methods",getPropertyValue("Access-Control-Allow-Methods"));
        response.setHeader("Access-Control-Allow-Headers", getPropertyValue("Access-Control-Allow-Headers"));
        filterChain.doFilter(servletRequest,response);

    }

    @Override
    public void destroy() {

    }
}

