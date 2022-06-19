package Sbchalet.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sbchalet.demo.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	Optional<User> findById(Long id);
	Optional<User> findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email, String password);
	
	
 
}
