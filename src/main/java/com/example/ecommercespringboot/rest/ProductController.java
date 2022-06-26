package com.example.ecommercespringboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommercespringboot.entity.Product;
import com.example.ecommercespringboot.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService theProductService) {
		productService = theProductService;
	}
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return productService.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product findProductbyId(@PathVariable int id ) {
		return productService.findById(id);
	}
	
	@GetMapping("/categories/{idCategory}/products")
	public List<Product> findbycategory(@PathVariable int idCategory){
		return productService.findByIdCategory(idCategory);
	}
	
	@GetMapping("/categories/{idCategory}/products/{idProduct}")
	public Product findbyCategoryAndIdProduct(@PathVariable int idCategory,@PathVariable int idProduct) {
		return productService.findByIdCateforyAndId(idCategory, idProduct);
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		productService.save(product);
	}
	
	@PutMapping("/products")
	public void updateProduct(@RequestBody Product product) {
		productService.save(product);
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteById(id);
	}

}
