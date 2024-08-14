package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public String getAllProducts(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		model.addAttribute("product", new Product());
		return "products";
	}

	@PostMapping
	public String createProduct(@ModelAttribute Product product) {
		productRepository.save(product);
		return "redirect:/products";
	}

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable Long id, Model model) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
		model.addAttribute("product", product);
		return "edit_product";
	}

	@PostMapping("/update/{id}")
	public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
		product.setId(id);
		productRepository.save(product);
		return "redirect:/products";
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
		productRepository.delete(product);
		return "redirect:/products";
	}
}
