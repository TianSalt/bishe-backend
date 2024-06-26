package moe.seclan.backend;

import io.jsonwebtoken.*;
import moe.seclan.backend.mapper.ExamMapper;
import moe.seclan.backend.pojo.Exam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

//@SpringBootTest
class BackendApplicationTests {

    private String signature = "signature";

//    @Autowired private ExamMapper examMapper;

    @Test
    void contextLoads() {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("username", "John Smith")
                .claim("role", "teacher")
                .setSubject("exam-system")
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 7 * 60 * 60 * 24))
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

//    @Test
//    void useId() {
//        Exam exam = new Exam(null, 57, null, null, null, null, null);
//        examMapper.insert(exam);
//        System.out.println(exam.getExamId());
//    }

    @Test
    void testDecimal() {
        System.out.println(BigDecimal.valueOf(0.2000000000000000000000000000000000000001));
    }

}
