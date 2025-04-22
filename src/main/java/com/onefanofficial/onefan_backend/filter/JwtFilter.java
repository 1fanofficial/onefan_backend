package com.onefanofficial.onefan_backend.filter;


import com.onefanofficial.onefan_backend.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        UUID userId;
        String jwt;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            try {
                userId = jwtUtil.extractUsername(jwt);

                if (userId != null) {
                    // Create authentication object
                    PreAuthenticatedAuthenticationToken authToken = new PreAuthenticatedAuthenticationToken(
                            userId.toString(),  // principal
                            jwt,       // credentials (the token itself)
                            Collections.emptyList()  // authorities
                    );

                    // set Authentication context
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } catch (Exception e) {
                // Don't set the authentication if token is invalid
                SecurityContextHolder.clearContext();
            }
        }
        chain.doFilter(request, response);
    }
}
