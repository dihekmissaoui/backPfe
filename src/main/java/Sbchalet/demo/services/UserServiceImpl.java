package Sbchalet.demo.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Sbchalet.demo.exception.UserNotFoundException;
import Sbchalet.demo.models.ERole;
import Sbchalet.demo.models.Role;
import Sbchalet.demo.models.User;
import Sbchalet.demo.payload.request.LoginRequest;
import Sbchalet.demo.payload.request.SignupRequest;
import Sbchalet.demo.payload.response.JwtResponse;
import Sbchalet.demo.repository.RoleRepository;
import Sbchalet.demo.repository.UserRepository;
import Sbchalet.demo.security.jwt.JwtUtils;
@Service
public class UserServiceImpl implements IUserservice {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUtils jwtUtils;


	@Override
	public User saveUser(SignupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public Set<Role> generateUserRole(SignupRequest signUpRequest){
		
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {

			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;

				case "user":
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
					break;
				default:
					Role userRole1 = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole1);

				}
			});
		}
		return roles;
	}	
	
	@Override
	public User generateUser( SignupRequest signUpRequest) {
		String userName = signUpRequest.getUsername();
		String nom = signUpRequest.getNom();
		String prenom = signUpRequest.getPrenom();
		String email = signUpRequest.getEmail();
		String password = signUpRequest.getPassword();
		String encodedPassword = encoder.encode(password);

		return new User(userName, nom, prenom, email, encodedPassword);
	}
	
	@Override
	public String checkForExistance(SignupRequest signUpRequest) {
		String message = "";
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			message = "Error: Username is already taken!";
		}
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			message = "Error: Email is already in use!";
		}
		return message;
	}

	@Override
	public ResponseEntity<?> authenticate(@Valid LoginRequest loginRequest) {
		Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("Not Found");
		}

		User user = optionalUser.get();

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}
}
