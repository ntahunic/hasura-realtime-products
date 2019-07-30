package com.abh.hasurarealtime.repositories;

import com.abh.hasurarealtime.data.dtos.ProductDto;
import com.abh.hasurarealtime.data.models.Product;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, UUID> {
	Page<ProductDto> findByNameIgnoreCaseContaining(String name, Pageable var1);
}
