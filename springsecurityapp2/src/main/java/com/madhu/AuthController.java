package com.madhu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JwtAuthProvider jwtAuthProvider;

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String loginHandler(@RequestBody LoginRequest request) {

		String email = request.getEmail();

		UserDetails userDetails = userService.loadUserByUsername(email);

		if (!passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
			return "Password Not Matched";
		}

		String jwt = jwtAuthProvider.generateToken(email);

		return jwt;
	}

	@PostMapping("/createUser")
	public String createUser(@RequestBody User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user).toString();
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello Madhu ";
	}

}
