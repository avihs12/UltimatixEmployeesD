// package com.example.UltimatixEmployeesD.config;


// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/api/v1/auth")
// public class AuthenticationController {

//   private  AuthenticationService service;

//   @PostMapping("/register")
//   public ResponseEntity<String> register(
//     @RequestBody RegisterRequest request) {
//     return ResponseEntity.ok(service.register(request));
//   }

//   @PostMapping("/authenticate")
//   public ResponseEntity<String> authenticate(
//     @RequestBody AuthenticationRequest request) {
//     return ResponseEntity.ok(service.authenticate(request));
//   }
// }

// // import jakarta.servlet.FilterChain;
// // import jakarta.servlet.ServletException;
// // import jakarta.servlet.http.HttpServletRequest;
// // import jakarta.servlet.http.HttpServletResponse;
// // import java.io.IOException;
// // import lombok.RequiredArgsConstructor;
// // import java.security.Security;
// // import org.springframework.lang.NonNull;
// // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// // import org.springframework.security.core.context.SecurityContextHolder;
// // import org.springframework.security.core.userdetails.UserDetails;
// // import org.springframework.security.core.userdetails.UserDetailsService;
// // import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// // import org.springframework.stereotype.Component;
// // import org.springframework.web.filter.OncePerRequestFilter;

// // @Component
// // public class JwtAuthenticationFilter extends OncePerRequestFilter {

// //   private  JwtService jwtService;
// //   private  UserDetailsService userDetailsService;

// //   @Override
// //   protected void doFilterInternal(
// //       @NonNull HttpServletRequest request,
// //       @NonNull HttpServletResponse response,
// //       @NonNull FilterChain filterChain
// //   ) throws ServletException, IOException {
// //     final String authHeader = request.getHeader("Authorization");
// //     final String jwt;
// //     final String userEmail;
// //     if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
// //       filterChain.doFilter(request, response);
// //       return;
// //     }
// //     jwt = authHeader.substring(7);
// //     userEmail = jwtService.extractUsername(jwt);
// //     if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
// //       UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
// //       if (jwtService.isTokenValid(jwt, userDetails)) {
// //         UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
// //             userDetails,
// //             null,
// //             userDetails.getAuthorities()
// //         );
// //         authToken.setDetails(
// //             new WebAuthenticationDetailsSource().buildDetails(request)
// //         );
// //         SecurityContextHolder.getContext().setAuthentication(authToken);
// //       }
// //     }
// //     filterChain.doFilter(request, response);
// //   }
// // }






















// // import java.io.IOException;


// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// // import org.springframework.security.core.context.SecurityContextHolder;
// // import org.springframework.security.core.userdetails.UserDetails;
// // import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// // import org.springframework.web.filter.OncePerRequestFilter;
// // import com.example.UltimatixEmployeesD.UserDetailsServiceImpl;
// // import io.jsonwebtoken.ExpiredJwtException;
// // import jakarta.servlet.FilterChain;
// // import jakarta.servlet.ServletException;
// // import jakarta.servlet.http.HttpServletRequest;
// // import jakarta.servlet.http.HttpServletResponse;


// // public class JwtRequestFilter extends OncePerRequestFilter{
// //     @Autowired
// // 	private UserDetailsServiceImpl userDetails;

// // 	@Autowired
// // 	private JwtTokenUtil jwtTokenUtil;

// // 	@Override
// // 	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
// // 			throws ServletException, IOException {

// // 		final String requestTokenHeader = request.getHeader("Authorization");

// // 		String username = null;
// // 		String jwtToken = null;
// // 		// JWT Token is in the form "Bearer token". Remove Bearer word and get
// // 		// only the Token
// // 		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
// // 			jwtToken = requestTokenHeader.substring(7);
// // 			try {
// // 				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
// // 			} catch (IllegalArgumentException e) {
// // 				System.out.println("Unable to get JWT Token");
// // 			} catch (ExpiredJwtException e) {
// // 				System.out.println("JWT Token has expired");
// // 			}
// // 		} else {
// // 			logger.warn("JWT Token does not begin with Bearer String");
// // 		}

// // 		// Once we get the token validate it.
// // 		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

// // 			UserDetails userDetails = this.userDetails.loadUserByUsername(username);

// // 			// if token is valid configure Spring Security to manually set
// // 			// authentication
// // 			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

// // 				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
// // 						userDetails, null, userDetails.getAuthorities());
// // 				usernamePasswordAuthenticationToken
// // 						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
// // 				// After setting the Authentication in the context, we specify
// // 				// that the current user is authenticated. So it passes the
// // 				// Spring Security Configurations successfully.
// // 				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
// // 			}
// // 		}
// // 		chain.doFilter(request, response);
// // 	}

// // }
