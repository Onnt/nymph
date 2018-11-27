package cn.virde.nymph.code.jwt;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author Virde
 * 2018年1月17日 下午4:11:07
 */
public class JwtUtil {


	private static String profiles = "ZheGeKeYiShiSuiBianDeZiFu";
	private static String JWT_SECRET = "ZheGeYeShi";
	
	/**
	 * 
	 * @author Virde
	 * 2018年2月27日 下午1:40:40
	 * @param jwt jwt字段
	 * @return 返回
	 */
	public static String encode(Jwt jwt){
		return low_encode(jwt.toString());
	}
	
	/**
	 * 
	 * @author Virde
	 * 2018年2月27日 下午1:40:44
	 * @param id id字段
	 * @return 返回
	 */
	public static String encode(String id) {
		return encode(new Jwt(id));
	}
	  /**
	  * 解密 jwt
	  * @param jwt jwt字段
	  * @return 返回
	  * @throws MalformedJwtException 异常
	  */
	  public static Jwt decode(String jwt) throws MalformedJwtException{
	       String json = low_decode(jwt);
	       return JSON.parseObject(json, Jwt.class);
	 }
	  
	/**
	  * 创建 jwt
	  * @param id id字段
	  * @return 返回
	  * @throws Exception 异常
	  */
	  private static String low_encode(String id){
	       SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256 ;
	       long nowMillis = System. currentTimeMillis();
	       Date now = new Date( nowMillis);
	       SecretKey key = generalKey();
	       JwtBuilder builder = Jwts. builder()
	            .setId(id)
	            .setIssuedAt(now)
	            .setSubject("auth")
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
	   * 
	   * @author Virde
	   * 2018年2月27日 下午1:41:04
	   * @param jwt jwt字段
	   * @return 返回
	   * @throws MalformedJwtException 异常
	   */
	 private static String low_decode(String jwt) throws MalformedJwtException{
	       try {
	    	   SecretKey key = generalKey();
	    	   Claims claims = Jwts. parser()
	    			   .setSigningKey( key)
	    			   .parseClaimsJws( jwt).getBody();
		       return claims.getId();
	       }catch(MalformedJwtException e) {
	    	   throw e ;
	       }
	 }
	  
	private static SecretKey generalKey(){
		String stringKey = profiles+ JWT_SECRET;
		byte[] encodedKey = Base64.decodeBase64(stringKey);
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		return key;
	}
	
	public static boolean isErrorFormatJwt(String jwt){
		try{
			decode(jwt);
			return false ;
		}catch(Exception e){
			return true ;
		}
	}
}
