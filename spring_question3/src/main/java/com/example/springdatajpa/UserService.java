package com.example.springdatajpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User user) {
		if (userRepository.existsById(id)) {
			user.setId(id);
			return userRepository.save(user);
		} else {
			return null;
		}
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
