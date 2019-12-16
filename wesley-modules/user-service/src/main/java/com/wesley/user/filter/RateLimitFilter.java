/**
 * 
 */
package com.wesley.user.filter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Guava 流量控制器
 *
 * OncePerRequestFilter 一个请求只会被过滤器执行一次
 * @author jojo
 */
@Component
@Order(1)
public class RateLimitFilter extends OncePerRequestFilter {

    /**
     * 每秒一次请求
     */
	private RateLimiter rateLimiter = RateLimiter.create(1);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println(1);
		
		if(rateLimiter.tryAcquire()) {
			filterChain.doFilter(request, response);
		}else {
			response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
			response.getWriter().write("too many request!!!");
			response.getWriter().flush();
		}
		
	}

}
