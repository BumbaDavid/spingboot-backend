package com.example.demo.controller;

import javax.validation.constraints.NotNull;

import com.example.demo.repository.ProductRepository;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



import com.example.demo.model.Product;

import com.example.demo.service.ProductService;

import java.util.*;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	public ProductController(ProductService productService, ProductRepository productRepository){
		this.productService = productService;
		this.productRepository = productRepository;
	}

        @GetMapping(value = {"","/"})
        public @NotNull Iterable<Product> getProducts(){
            return productService.getAllProducts();
        }


	private Sort.Direction getSortDirection(String direction) {
		if (direction.equals("asc")) {
			return Sort.Direction.ASC;
		} else if (direction.equals("desc")) {
			return Sort.Direction.DESC;
		}

		return Sort.Direction.ASC;
	}


	@GetMapping("/products")
	public ResponseEntity<Map<String, Object>> getAllProducts(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size,
			@And({
					@Spec(path = "name" , spec = Equal.class),
					@Spec(path = "price", spec = Equal.class),
					@Spec(path = "ram", spec = Equal.class),
					@Spec(path = "brand", spec = Equal.class),
					@Spec(path = "operatingSystem", spec = Equal.class)
			})Specification<Product> productSpec, Pageable pageable){

	try{

		List<Product> products = new ArrayList<Product>();
		Page<Product> pageTuts;



		pageTuts = productRepository.findAll(productSpec, pageable);

		products = pageTuts.getContent();

		Map<String, Object> response = new HashMap<>();
		response.put("products", products);
		response.put("currentPage", pageTuts.getNumber());
		response.put("totalItems", pageTuts.getTotalElements());
		response.put("totalPages", pageTuts.getTotalPages());
		response.put("itemsPerPage", pageTuts.getSize());

		return new ResponseEntity<>(response, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		Optional<Product> tutorialData = productRepository.findById(id);

		return tutorialData.map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
