package com.woniuxy.snailrestaurant.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.woniuxy.snailrestaurant.common.Sha256;
import org.junit.jupiter.api.Test;

public class JwtTest {
    @Test
    void genJwt() {
        Algorithm secret = Algorithm.HMAC256("secret");
        String sign = JWT.create().withClaim("aaa", "fghjk").sign(secret);

    }

    @Test
    void shaTest() {
        String hihihi = Sha256.encrypt("hihihi");
        System.out.println(hihihi);
        System.out.println(Sha256.verify("hihihi","f42ff50167e9c6cc7e45a597368484d622fcd95aae12d3704b647023648bec9t"));

    }

}
