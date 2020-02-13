package com.xuxian;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ParseJjwt {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMjMiLCJzdWIiOiLmtYvor5UiLCJpYXQiOjE1ODE1NzE4MDUsImV4cCI6MTU4MTU3MTg2NCwicm9sZXMiOiJhZG1pbiJ9.aqPhnVRoE7p5VY5t2WcdBYAFvSNXeowMwgQ9dzpKUuk";
        Claims claims = Jwts.parser().setSigningKey("ceshi").parseClaimsJws(token).getBody();
        System.out.println("id:"+claims.getId()+"\n subject:"+claims.getSubject()+"\n IssuedAt:"+claims.getIssuedAt()+"\n roles："+claims.get("roles")+"\n exp:"+claims.getExpiration());
    }
}
