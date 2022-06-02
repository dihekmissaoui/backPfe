package Sbchalet.demo.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Sbchalet.demo.models.ERole;
import Sbchalet.demo.models.Role;
import Sbchalet.demo.models.User;
import Sbchalet.demo.payload.request.SignupRequest;
import Sbchalet.demo.repository.RoleRepository;
import Sbchalet.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements IUserservice {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	
	

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
}
