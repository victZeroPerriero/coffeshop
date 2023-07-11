package com.example.coffeshop.jwt;

import com.example.coffeshop.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;

@Component
@Slf4j
public class JwtUtils {
    @Value("${bezkoder.app.jwtCookieName}")
    private String jwtCookie;
    @Value("${bezkoder.app.jwtSecret}")
    private String jwtSecret;
    @Value("${bezkoder.app.jwtExpirationMs}")
    private String jwtExiprations;
    public String getJwtFromCookies(HttpServletRequest request){
      Cookie cookie = WebUtils.getCookie(request,jwtCookie);
      if (cookie != null){
          return cookie.getValue();
      }
      return null;
    }
    public String generateJwtFromUserName(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExiprations))
                .signWith(key(),SignatureAlgorithm.HS256)
                .compact();
    }
    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
    public ResponseCookie generateJwtFromCookies(UserDetailsImpl principal){
       String jwt = generateJwtFromUserName(principal.getUsername());
        return ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
    }
    public ResponseCookie getCleanCookie(){
       return ResponseCookie.from(jwtCookie, null).path("/api").build();
    }
    public String getUserNameFromJwt(String token){
        return Jwts.parserBuilder().setSigningKey(key())
                .build().parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
