package Sbchalet.demo.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Sbchalet.demo.exception.NotfoundException;
import Sbchalet.demo.exception.UserNotFoundException;
import Sbchalet.demo.models.ERole;
import Sbchalet.demo.models.Role;
import Sbchalet.demo.models.User;
import Sbchalet.demo.payload.request.LoginRequest;
import Sbchalet.demo.payload.request.SignupRequest;
import Sbchalet.demo.payload.response.JwtResponse;
import Sbchalet.demo.payload.response.MessageResponse;
import Sbchalet.demo.repository.RoleRepository;
import Sbchalet.demo.repository.UserRepository;
import Sbchalet.demo.security.jwt.JwtUtils;
import Sbchalet.demo.services.IUserservice;
import Sbchalet.demo.services.UserDetailsImpl;
import Sbchalet.demo.services.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
 	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;

	IUserservice userService;

	@Autowired
	public void setUserServiceImpl(UserServiceImpl userService) {
		this.userService = userService;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		
		
		return this.userService.authenticate(loginRequest);

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) throws NotfoundException {

		this.checkForExistance(signUpRequest);
		User user = generateUser(signUpRequest);
		Set<Role> roles = generateUserRole(signUpRequest);
		user.setRoles(roles);
		Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));

		if (roles.contains(adminRole)){
			user.setUsername(signUpRequest.getEmail().substring(0, signUpRequest.getEmail().indexOf('@')));
		}
		User savedUser = userRepository.save(user);
		return this.userService.authenticate(new LoginRequest(signUpRequest.getEmail(),signUpRequest.getPassword()));
	}

	private Set<Role> generateUserRole(SignupRequest signUpRequest) {
		return this.userService.generateUserRole(signUpRequest);
	}

	private User generateUser(SignupRequest signUpRequest) {
		return this.userService.generateUser(signUpRequest);

	}

	private ResponseEntity<MessageResponse> checkForExistance(SignupRequest signUpRequest) {

		String message = this.userService.checkForExistance(signUpRequest);
		return ResponseEntity.badRequest().body(new MessageResponse(message));

	}

}
