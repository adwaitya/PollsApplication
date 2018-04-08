package com.app.polls.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.polls.service.CustomUserDetailsService;
import com.app.polls.util.JwtTokenProvider;

import org.springframework.util.StringUtils;

public class JWTAuthenticationFilter  extends OncePerRequestFilter {
	  @Autowired
	    JwtTokenProvider tokenProvider;

	    @Autowired
	    CustomUserDetailsService customUserDetailsService;

	    @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	        String jwt = getJwtFromRequest(request);

	        if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
	            Long userId = tokenProvider.getUserIdFromJWT(jwt);

	            UserDetails userDetails = customUserDetailsService.loadUserById(userId);
	            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

	            SecurityContextHolder.getContext().setAuthentication(authentication);
	        }

	        filterChain.doFilter(request, response);
	    }

	    private String getJwtFromRequest(HttpServletRequest request) {
	        String bearerToken = request.getHeader("Authorization");
	        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
	            return bearerToken.substring(7, bearerToken.length());
	        }
	        return null;
	    }
}
