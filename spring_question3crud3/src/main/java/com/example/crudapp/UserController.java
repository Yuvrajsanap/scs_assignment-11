package com.example.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "index";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID:" + id));
		model.addAttribute("user", user);
		return "form";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
}
