package com.wdg.renting.main.utils;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.utils
 * @Author: 吴第广
 * @CreateTime: 2023-04-23  11:24
 * @Description: TODO
 * @Version: 1.0
 */

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Data
@Component
public class JwtUtils {

    // 过期时间，单位为秒
    private static final long EXPIRATION = 3600;

    // 密钥
    private static final String SECRET_KEY = "5555";

    /**
     * 生成JWT
     *
     * @param subject 主题
     * @return JWT字符串
     */
    public static String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * 从请求中获取JWT
     *
     * @param request 请求对象
     * @return JWT字符串
     */
    public static String getTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(token) && token.startsWith("Bearer ")) {
            return token.replace("Bearer ", "");
        }
        return null;
    }

    /**
     * 验证JWT
     *
     * @param token JWT字符串
     * @return 校验结果
     */
    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 从JWT中解析主题
     *
     * @param token JWT字符串
     * @return 主题
     */
    public static String getUserIdFromToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }
}

