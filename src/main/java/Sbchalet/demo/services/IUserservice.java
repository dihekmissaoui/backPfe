package Sbchalet.demo.services;

import java.util.Set;

import javax.validation.Valid;

import Sbchalet.demo.models.Role;
import Sbchalet.demo.models.User;

import Sbchalet.demo.payload.request.SignupRequest;

public interface IUserservice {
	
	User saveUser(SignupRequest request);
	User saveUser(User user);
	public Set<Role> generateUserRole(SignupRequest signUpRequest);
	public User generateUser(@Valid SignupRequest signUpRequest);
	public String checkForExistance(SignupRequest signUpRequest);

}
