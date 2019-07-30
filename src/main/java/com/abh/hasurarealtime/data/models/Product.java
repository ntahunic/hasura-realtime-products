package com.abh.hasurarealtime.data.models;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	private String name;
	private double salePrice;
	private double msrp;
	@Column(columnDefinition = "text")
	private String categoryPath;
	@Column(columnDefinition = "text")
	private String shortDescription;
	@Column(columnDefinition = "text")
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
}
