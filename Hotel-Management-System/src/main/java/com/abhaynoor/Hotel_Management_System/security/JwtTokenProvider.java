package com.abhaynoor.Hotel_Management_System.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

	@Value("${app.jwt-secret-string}")
	private String jwtSecretString;
	@Value("${app.jwt-expiration-milliseconds}")
	private long  jwtExpirationDate;
	
	public String generateJwtToken(Authentication authentication) {
		String name= authentication.getName();
		Date currentDate= new Date();
		Date expireDate= new Date(currentDate.getTime()+jwtExpirationDate);
		
		String token= Jwts.builder()
						  .subject(name)
						  .issuedAt(currentDate)
						  .expiration(expireDate)
						  .signWith(key(),Jwts.SIG.HS256)
						  .compact();
		return token;
	}
	private SecretKey key() {
		return Keys.hmacShaKeyFor(jwtSecretString.getBytes());
	}
	// get username from token
		public String getUsername(String token) {
			return Jwts.parser()
					.verifyWith(key())
					.build()
			        .parseSignedClaims(token)
			        .getPayload()
			        .getSubject();
		}
		public boolean validateToken(String token) {
			 Jwts.parser()
				 .verifyWith(key())
				 .build()
				 .parse(token);
			return true;
		}
}
