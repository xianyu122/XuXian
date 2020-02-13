package com.xuxian;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class CreateJjwt {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        long exp = l+1000*60;
        JwtBuilder builder = Jwts.builder()
                .setId("123")
                .setSubject("测试")
                .setIssuedAt(new Date())
                .setExpiration(new Date(exp))
                .claim("roles","admin")
                .signWith(SignatureAlgorithm.HS256,"ceshi");
        System.out.println(builder.compact());
    }
}
