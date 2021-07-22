package fftl.fftl03RemakeBoard.config.security;

import fftl.fftl03RemakeBoard.entity.User;
import fftl.fftl03RemakeBoard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
/**
 * Parameter 0 of constructor in fftl.fftl03RemakeBoard.controller.UserController required a bean of type 'fftl.fftl03RemakeBoard.config.security.JwtTokenProvider' that could not be found.
 * Consider defining a bean of type 'fftl.fftl03RemakeBoard.config.security.JwtTokenProvider' in your configuration.
 * 위의 Component 가 위 에러를 해결해주었다.
 * */

public class JwtTokenProvider {

    @Value("${spring.jwt.secret")
    private String secretKey;

    private long tokenValidMilliSecond = 1000L * 60 * 120; //2시간 유효기간
    private final UserService userService;

    /**
     * 잘 모른다! 알아보자!
     * */
    @PostConstruct
    protected  void init() { secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes()); }

    //유저 정보와 등급을 통하여 토큰을 생성해냅니다.
    public String createToken(String username, List<String> roles){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidMilliSecond))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token){
//        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserName(token));
        UserDetails userDetails = userService.findByUsername(this.getUserName(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    //토큰을 이용하여 username 을 얻어낸다.
    public String getUserName(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    //Header를 통해 받아온 토큰에서 필요 없는 부분을 잘라낸다.
    public String resolveToken(HttpServletRequest req){
        String myToken = req.getHeader("Authorization");

        if(myToken == null){
            return null;
        }

//        String realToken = myToken.substring("Bearer".length());

        return myToken;
    }

    //토큰의 유효기간이 지났는지 아닌지 확인한다.
    public boolean validateToken(String jwtToken){
        try{
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e){
            return false;
        }
    }

}