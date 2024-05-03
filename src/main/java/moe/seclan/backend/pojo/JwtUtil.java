package moe.seclan.backend.pojo;

import io.jsonwebtoken.*;

import java.util.UUID;

public class JwtUtil {

    static String signature = "Boku to keiyakushite, mahoushoujo ni natte hoshii n da!";

    public static String createToken(Integer uid, String role) {
        JwtBuilder jwtBuilder = Jwts.builder();

        return jwtBuilder
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                .claim("uid", uid)
                .claim("role", role)
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
    }


    public static Boolean checkToken(String token) {
        if (token == null) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
