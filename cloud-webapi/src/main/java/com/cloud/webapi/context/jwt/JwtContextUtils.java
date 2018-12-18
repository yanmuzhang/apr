package com.cloud.webapi.context.jwt;

import cn.liberfree.common.exception.BusinessException;
import com.cloud.webapi.context.configration.CloudConfigProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: zhangchao
 * @time: 2018-12-18 10:34
 **/

@Component
public class JwtContextUtils {

    @Autowired
    private CloudConfigProperties cloudConfigProperties;


    public  String create(JwtUser user) {
        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("id", user.getId());

        //下面就是在为payload添加各种标准声明和私有声明了
        //这里其实就是new一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(UUID.randomUUID().toString())
                //iat: jwt的签发时间
                .setIssuedAt(now)
                //代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .setSubject(user.getId())
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, cloudConfigProperties.getJwt().getSecret());
        long expMillis = nowMillis + cloudConfigProperties.getJwt().getExpiration();
        Date exp = new Date(expMillis);
        //设置过期时间
        builder.setExpiration(exp);
        return builder.compact();
    }


    /**
     * Token的解密
     * @param token 加密后的token
     * @return
     */
    public JwtUser parse(String token) {
        if(StringUtils.isEmpty(token)){
            return null;
        }
        //得到DefaultJwtParser
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    //设置签名的秘钥
                    .setSigningKey(cloudConfigProperties.getJwt().getSecret())
                    //设置需要解析的jwt
                    .parseClaimsJws(token).getBody();
        }catch (Exception e){
            e.printStackTrace();
          return null;
        }
        JwtUser user = new JwtUser();
        user.setId(claims.get("id",String.class));
        return user;
    }


    public void verifyToken(String token) {
        //得到DefaultJwtParser
        if(StringUtils.isEmpty(token)){
            throw new NoLoginException("请登录");
        }
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    //设置签名的秘钥
                    .setSigningKey(cloudConfigProperties.getJwt().getSecret())
                    //设置需要解析的jwt
                    .parseClaimsJws(token).getBody();
        }catch (Exception e){
            throw new NoLoginException("解析token失败!");
        }
        Date expiration = claims.getExpiration();
        if(expiration.before(new Date())){
            throw new NoLoginException("会话已过期");
        }
    }

}
