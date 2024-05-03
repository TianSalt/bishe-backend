package moe.seclan.backend;

import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;


class BackendApplicationTests {

    private String signature = "signature";

    @Test
    void contextLoads() {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("username", "tom")
                .claim("role", "admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        System.out.println(jwtToken);
    }

    @Test
    void parse() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE3MTQ3MjQwMjcsImp0aSI6IjUyMDVkNDM1LTY3ZTAtNDg4OC1hNDY3LWQxNDI0YmZkNTA3MiJ9.bLSmCujrx0aFwKJcMOyeng9peSA3SXtsDhpv6VYRkFc";
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        System.out.println(claimsJws.getBody().get("username"));
        System.out.println(claimsJws.getBody().get("role"));
        System.out.println(claimsJws.getBody().getExpiration());
    }

}
