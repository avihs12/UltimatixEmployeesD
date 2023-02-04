// package com.example.UltimatixEmployeesD.config;

// import com.example.UltimatixEmployeesD.auth.JwtService;
// import com.example.UltimatixEmployeesD.entity.User;
// import com.example.UltimatixEmployeesD.repository.UserRepository;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import com.example.UltimatixEmployeesD.service.EmployeeService;
// import com.example.UltimatixEmployeesD.repository.UserRepository;
// import com.example.UltimatixEmployeesD.entity.User;
// @Service
// public class AuthenticationService {
//   private  UserRepository repository;
//   private  PasswordEncoder passwordEncoder;
//   private  JwtService jwtService;
//   private  AuthenticationManager authenticationManager;
//   private EmployeeService service;
//   private User user;

//   public String register(RegisterRequest request) {
    
//     user.setUsername(request.getUsername());
//     user.setFirstname(request.getFirstname());
//     user.setLastname(request.getLastname());
//     user.setPassword(request.getPassword());
//     user.setSalary(request.getSalary());
//     user.setSalaryhike(request.getSalaryhike());
//     user.setEmployeeid(request.getEmployeeid());
//     user.setIsAccountNonExpired(true);
//     user.setIsAccountNonLocked(true);
//     user.setIsCredentialsNonExpired(true);
//     user.setIsEnabled(true);
//     repository.save(user);  
//     UserDetails userDetails = (UserDetails) user;
//     var jwtToken = jwtService.generateToken(userDetails);
//     return jwtToken;
//   }

//   public String authenticate(AuthenticationRequest request) {
//     authenticationManager.authenticate(
//         new UsernamePasswordAuthenticationToken(
//             request.getUsername(),
//             request.getPassword()
//         )
//     );
//     var user = repository.getUserByUsername(request.getUsername());
//     UserDetails userDetails = (UserDetails) user;
//     var jwtToken = jwtService.generateToken(userDetails);
//     return jwtToken;
//   }
// }














// // import org.springframework.beans.factory.annotation.Value;
// // import org.springframework.security.core.userdetails.UserDetails;
// // import org.springframework.stereotype.Component;

// // import com.example.UltimatixEmployeesD.entity.User;

// // import io.jsonwebtoken.Claims;
// // import java.io.Serializable;
// // import java.util.Date;
// // import java.util.HashMap;
// // import java.util.Map;
// // import java.util.function.Function;
// // import io.jsonwebtoken.Jwts;
// // import io.jsonwebtoken.SignatureAlgorithm;

// // @Component
// // public class JwtTokenUtil  implements Serializable {
// //     private static final long serialVersionUID = -2550185165626007488L;

// // 	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

// // 	@Value("8091879091924046844L")
// // 	private String secret;

// // 	//retrieve username from jwt token
// // 	public String getUsernameFromToken(String token) {
// // 		return getClaimFromToken(token, Claims::getSubject);
// // 	}

// // 	//retrieve expiration date from jwt token
// // 	public Date getExpirationDateFromToken(String token) {
// // 		return getClaimFromToken(token, Claims::getExpiration);
// // 	}

// // 	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
// // 		final User claims = getAllClaimsFromToken(token);
// // 		return claimsResolver.apply((Claims) claims);
// // 	}
    
// // 	private User getAllClaimsFromToken(String token) {
// // 		// return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
// //         return (User) Jwts.parserBuilder()
// //         .requireAudience(secret)
// //         .build()
// //         .parse(token).getBody();
// // 	}

// // 	//check if the token has expired
// // 	private Boolean isTokenExpired(String token) {
// // 		final Date expiration = getExpirationDateFromToken(token);
// // 		return expiration.before(new Date());
// // 	}

// // 	//generate token for user
// // 	public String generateToken(User user) {
// // 		Map<String, Object> claims = new HashMap<>();
// // 		return doGenerateToken(claims, user.getUsername());
// // 	}

// // 	//while creating the token -
// // 	//1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
// // 	//2. Sign the JWT using the HS512 algorithm and secret key.
// // 	//3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
// // 	//   compaction of the JWT to a URL-safe string 
// // 	private String doGenerateToken(Map<String, Object> claims, String subject) {

// // 		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
// // 				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
// // 				.signWith(SignatureAlgorithm.HS512, secret).compact();
// // 	}

// // 	//validate token
// // 	public Boolean validateToken(String token, UserDetails userDetails) {
// // 		final String username = getUsernameFromToken(token);
// // 		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
// // 	}
// // }
