package com.vf.dev.msuniversidadauth.conf.filters;

import com.vf.dev.msuniversidadauth.util.jwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private jwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        boolean existToken = verifyTokenExist(request);
        if (existToken) {
            Claims claims = jwtUtil.getAuthentication(request, response);
        }
        filterChain.doFilter(request,response);
    }


    private boolean verifyTokenExist(HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");
        if (jwt != null)
            return true;
        return false;

    }
}
