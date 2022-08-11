package com.portfolio.gnr.Security.jwt;

import com.portfolio.gnr.Security.Service.UserDetailsImp;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;


public class JwtTokenFilter extends OncePerRequestFilter{
     private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
     
     @Autowired
     JwtProvider jwtProvider;
     @Autowired
     UserDetailsImp userDetailsServiceImp;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = getToken(request);
            if (token != null && jwtProvider.validateToken(token)){
                String nombreUsuario = userDetailsServiceImp.loadUserByUsername(token)
            }
        }
    }
}
