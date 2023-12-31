package com.example.canary.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.canary.common.token.TokenConstant;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jwt工具类
 *
 * @since 1.0
 * @author zhaohongliang
 */
public class JwtUtils {

    private JwtUtils() {

    }

    /**
     * 创建token
     *
     * @param secret 密钥
     * @param expires 过期间隔
     * @param claim 载荷
     * @param audience aud
     * @return
     */
    public static String createJwtToken(String secret, Duration expires, String claim, String... audience) {
        // 有效起始时间
        Date beginTime = new Date();
        // 有效结束时间
        Date endTime = new Date(System.currentTimeMillis() + expires.toMillis());

        // header
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        // 加密算法
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                // header
                .withHeader(header)
                // payload
                .withAudience(audience)
                .withIssuedAt(beginTime)
                .withExpiresAt(endTime)
                .withClaim(TokenConstant.CLAIM_DATA, claim)
                // sign
                .sign(algorithm);
    }

    /**
     * 创建token
     *
     * @param secret 密钥
     * @param expires 过期时间
     * @param claimMap 载荷map
     * @param audience aud
     * @return
     */
    public static String createJwtToken(String secret, Duration expires, Map<String, String> claimMap, String... audience) {
        // 有效起始时间
        Date beginTime = new Date();
        // 有效结束时间
        Date endTime = new Date(System.currentTimeMillis() + expires.toMillis());

        // header
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        // 加密算法
        Algorithm algorithm = Algorithm.HMAC256(secret);

        JWTCreator.Builder builder = JWT.create();
        builder
                // header
                .withHeader(header)
                // payload
                .withAudience(audience)
                .withIssuedAt(beginTime)
                .withExpiresAt(endTime);
        if (!CollectionUtils.isEmpty(claimMap)) {
            claimMap.forEach(builder::withClaim);
        }
        // sign
        return builder.sign(algorithm);

    }

    /**
     * 校验token
     *
     * @param secret
     * @param token
     * @return
     */
    public static boolean verify(String secret, String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm).build();
        try {
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }

    /**
     * 校验是否过期
     *
     * @param token
     * @return
     */
    public static boolean isExpired(String token) {
        DecodedJWT decodedJwt = JWT.decode(token);
        // 如果过期时间小于当前时间，则表示已过期
        return decodedJwt.getExpiresAt().getTime() < System.currentTimeMillis();
    }

    /**
     * 校验是否过期
     *
     * @param expiresAt
     * @return
     */
    public static boolean isExpired(Date expiresAt) {
        // 如果过期时间在当前日期之前，则表示已过期
        return expiresAt.before(new Date());
    }

    /**
     * 获取 aud
     *
     * @param token
     * @param index
     * @return
     */
    public static String getAudience(String token, int index) {
        DecodedJWT decodedJwt = JWT.decode(token);
        List<String> audiences = decodedJwt.getAudience();
        if (CollectionUtils.isEmpty(audiences)) {
            return null;
        }
        return decodedJwt.getAudience().get(index);
    }

    /**
     * 获取载荷
     *
     * @param token
     * @param keyName
     * @return
     */
    public static Claim getClaim(String token, String keyName) {
        DecodedJWT decodedJwt = JWT.decode(token);
        return decodedJwt.getClaim(keyName);
    }

    /**
     * 获取载荷字符串
     *
     * @param token
     * @param keyName
     * @return
     */
    public static String getClaimStr(String token, String keyName) {
        return JwtUtils.getClaim(token, keyName).asString();
    }

    /**
     * 获取过期时间
     *
     * @param token
     * @return
     */
    public static Date getExpiresAt(String token) {
        return JWT.decode(token).getExpiresAt();
    }

    public static void main(String[] args) throws InterruptedException {

        String secret = "test1234";
        Duration expires = Duration.ofMillis(1000);

        String token = JwtUtils.createJwtToken(secret, expires, "test","123456", "000");
        System.out.println(token);
        Thread.sleep(2000);
        System.out.println(JwtUtils.isExpired(token));
        System.out.println(JwtUtils.verify(secret, token));
        System.out.println(JwtUtils.getClaim(token, TokenConstant.CLAIM_DATA));
    }
}
