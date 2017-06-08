package cn.virde.nymph.code;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class NymCode {

	private String profiles = "iOiJteXBhc3MiLCJpY";
	private  String JWT_SECRET = "V4cCI6Mjk5Mjc3MjIzNn0";
	/**
	  * 创建 jwt
	  * @param id
	  * @param subject
	  * @param ttlMillis
	  * @return
	  * @throws Exception
	  */
	  public String encode(String id, String subject){
	       SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256 ;
	       long nowMillis = System. currentTimeMillis();
	       Date now = new Date( nowMillis);
	       SecretKey key = generalKey();
	       JwtBuilder builder = Jwts. builder()
	            .setId(id)
	            .setIssuedAt(now)
	            .setSubject(subject)
	           .signWith(signatureAlgorithm, key);
	       long ttlMillis = new Date().getTime();
	       if (ttlMillis >= 0){
	           long expMillis = nowMillis + ttlMillis;
	           Date exp = new Date( expMillis);
	           builder.setExpiration( exp);
	       }
	       return builder.compact();
	 }

	  /**
	  * 解密 jwt
	  * @param jwt
	  * @return
	  * @throws Exception
	  */
	  public Claims decode(String jwt){
	       SecretKey key = generalKey();
	       Claims claims = Jwts. parser()
	          .setSigningKey( key)
	          .parseClaimsJws( jwt).getBody();
	       return claims;
	 }
	  

	public SecretKey generalKey(){
		String stringKey = profiles+ JWT_SECRET;
		byte[] encodedKey = Base64.decodeBase64(stringKey);
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		return key;
	}
		
}
