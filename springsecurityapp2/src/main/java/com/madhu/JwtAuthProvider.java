package com.madhu;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtAuthProvider {

	// jwtSecretKey

	// private String jwtSecretKey = "sIoVC8OFOgmxbk9XRYtY2zMKXuYXBGL2d3x1IV37";
	private String jwtSecretKey = "12345678123456781234567812345678";

	// expirationTime
	private Long jwtExpiration = 500000L;

	// parsing the token

	public Claims parseToken(String token, String jwtSecretKey) {

		System.out.println("The jwt secret key in parsing token is " + jwtSecretKey);

		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(jwtSecretKey.getBytes()).build();

		Claims c = null;
		try {
		 c=  jwtParser.parseClaimsJws(token).getBody();
		
		}catch(Exception e) {
			System.out.println("parsing token failed "+e.getMessage());
		}
		
		System.out.println("claims are  "+c);
		
		return c;

	}

	// validating the token

	public boolean validateToken(String token, String jwtSecretKey) {
		
		System.out.println("inside validating 40");

		return parseToken(token, jwtSecretKey) != null;

	}

	// getUsername from the token
	public String getUsernameFromToken(String token, String jwtSecretKey) {


		Claims claims = parseToken(token, jwtSecretKey);

		if (claims != null) {
			
			System.out.println("the subject is "+claims.getSubject());
			return claims.getSubject();
		}
		else
			return null;

	}

	// generating the token

	public String generateToken(String phoneNumber) {

		System.out.println("The jwt Secret Key in Generating token is " + jwtSecretKey);

		Key key = Keys.hmacShaKeyFor(jwtSecretKey.getBytes());

		Date expire = new Date(new Date().getTime() + jwtExpiration);

		return Jwts.builder().setSubject(phoneNumber).setIssuedAt(new Date()).setExpiration(expire).signWith(key)
				.compact();

	}

}
