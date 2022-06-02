package Sbchalet.demo.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Sbchalet.demo.models.User;
import Sbchalet.demo.repository.UserRepository;
@Service

public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	UserRepository userRepository;
	private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
			logger.info(" je suis dans loadUserByUsername");
			User user = userRepository.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
			logger.debug("je vais build un User");
			return UserDetailsImpl.build(user);
			
		} catch (Exception e) {
			logger.error("Error avec UserDetails");
		}
		return null;
	
	}
	
	
	

}
