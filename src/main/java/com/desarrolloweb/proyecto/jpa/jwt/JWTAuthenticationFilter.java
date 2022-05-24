package com.desarrolloweb.proyecto.jpa.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desarrolloweb.proyecto.jpa.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    private AuthenticationManager authenticationManager;
    
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager)
    {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException
    {
        try
        {
            User credentials = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword(), new ArrayList<>()));
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException
    {
        var role = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));

        final Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("value1", "1");
        claims.put("othervalue", 100L);

        String token = Jwts.builder()
            .setIssuedAt(new Date())
            .setClaims(claims)
            .setSubject(((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername())
            .setExpiration(new Date(System.currentTimeMillis() + 3600000))
            .signWith(SignatureAlgorithm.HS512, "papa_heladino")
            .compact();

        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().write("Bearer " + token);
    }
}
