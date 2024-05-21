package moe.seclan.backend.pojo;

import io.jsonwebtoken.*;

import java.util.Date;
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
                .setSubject("exam-system")
                .setId(UUID.randomUUID().toString())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
    }


    public static boolean checkToken(String token) {
        if (token == null) {
            return false;
        }
        try {
            Claims claims = Jwts.parser().setSigningKey(signature).parseClaimsJws(token).getBody();
            if (claims.getExpiration().before(new java.util.Date())) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
