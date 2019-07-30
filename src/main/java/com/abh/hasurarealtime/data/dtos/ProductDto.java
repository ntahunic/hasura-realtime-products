package com.abh.hasurarealtime.data.dtos;

import com.abh.hasurarealtime.data.models.Product;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

	private UUID id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String name;
	private double salePrice;
	private double msrp;
	private String categoryPath;
	private String shortDescription;
	private String longDescription;
	private String brandName;
	private String color;
	private boolean shipToStore;
	private boolean freeShipToStore;
	private double customerRating;
	private Integer numReviews;
	private boolean stock;
	private String offerType;
	private boolean isTwoDayShippingEligible;
	private boolean availableOnline;

	public ProductDto(Product product) {
		this.id = product.getId();
		this.createdAt = product.getCreatedAt();
		this.updatedAt = product.getUpdatedAt();
		this.name = product.getName();
		salePrice = product.getSalePrice();
		msrp = product.getMsrp();
		categoryPath = product.getCategoryPath();
		shortDescription = product.getShortDescription();
		longDescription = product.getLongDescription();
		brandName = product.getBrandName();
		color = product.getColor();
		freeShipToStore = product.isFreeShipToStore();
		customerRating = product.getCustomerRating();
		numReviews = product.getNumReviews();
		stock = product.isStock();
		offerType = product.getOfferType();
		isTwoDayShippingEligible = product.isTwoDayShippingEligible();
		availableOnline = product.isAvailableOnline();
	}
}
