package com.abh.hasurarealtime.controllers;

import com.abh.hasurarealtime.data.dtos.ProductDto;
import com.abh.hasurarealtime.data.models.Product;
import com.abh.hasurarealtime.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/search")
	public Page<ProductDto> search(String query, Integer page, Integer size) {
		return productRepository.findByNameIgnoreCaseContaining(query,
			new PageRequest(page, size, new Sort(new Sort.Order(Sort.Direction.DESC, "updatedAt"))));
	}

	@PostMapping
	public ResponseEntity post(@RequestBody ProductDto productDto) {
		if (productDto == null || StringUtils.isEmpty(productDto.getName())) {
			log.error("POST /products error. Product title cannot be null.");
			return new ResponseEntity<>("Product title cannot be null.", HttpStatus.BAD_REQUEST);
		}

		Product p = Product.builder()
			.name(productDto.getName())
			.build();
		productRepository.save(p);

		return new ResponseEntity<>("New product successfully created.", HttpStatus.CREATED);
	}
}
