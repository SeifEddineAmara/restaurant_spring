package com.restaurant.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    public static final String SECRET = "heTQ8JYvH6iCLVuZeeC6LDdBfx9obPOojPLv3U67j+RLKjEOmt8VO1Hm6u+nJlxGUcWM5eGN6cz1NrbGxE5XSw/+Ml/6cnFXuSURy+godu/bf9DNxKyBd3GapT8KePdU59EDnpyp8swuhg7oMwS7mVsvaBAqoReba+c7MsaW2dZzp2sDv2oCqafsHWEAlaFZEh3uuK5CwatdxgnMDSf1XSneUWcwXq3O32mojTD697NWwexZ/dpo3V5EYc8gSGzo8ibHG9AQ9cmymiD+HRMszuy8jUuQNjLXet+Q8GoRd6VqlDwmlno9QEdhLX0DbRhrEXRjzqnIyv/blmLKhKT0Orubj+xvsUTGTVAl5Cym0sI=";

    public String generateToken(String email){
        Map<String,Object> claims =new HashMap<>();
        return createToken(claims,email);
}
private String createToken(Map<String,Object> claims,String email){

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
}
private Key getSignKey(){
byte[] keyBytes = Decoders.BASE64.decode(SECRET);
return Keys.hmacShaKeyFor(keyBytes);
}



}
