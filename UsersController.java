package net.javaguidesspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguidesspringboot.entity.Users;
import net.javaguidesspringboot.exception.ResourceNotFoundException;
import net.javaguidesspringboot.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	@Autowired
	private UserRepository userRepository;
	// get all users
	@GetMapping
	public List<Users> getAllUsers(){
		return this.userRepository.findAll();
	}
	// get users by id
	@GetMapping("/{id}")
	public Users getUserById(@PathVariable (value = "id")long userId) {
	return this.userRepository.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("Users not found with id :" + userId));
	}
	// create user
	@PostMapping
	public Users createUsers(@RequestBody Users users) {
		return this.userRepository.save(users);
	}
	
	// update user
	@PutMapping("/{id}")
	public Users updateUsers(@RequestBody Users users, @PathVariable("id") long userId) {
		Users existingUsers = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found with id :" + userId));
		existingUsers.setFirstname(users.getFirstname());
		existingUsers.setLastname(users.getLastname());
		existingUsers.setEmail(users.getEmail());
		return this.userRepository.save(existingUsers);
	}
	
	// delete user by id
	public ResponseEntity<Users> deleteUsers( @PathVariable("id") long userId){
		Users existingUsers = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found with id :" + userId));
this.userRepository.delete(existingUsers);
return ResponseEntity.ok().build();
	}
}
