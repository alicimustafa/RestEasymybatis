package com.mustafa.app.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Film {

	private Long id;
	private String title;
	private String description;
	private Date releaseYear;
	private Integer languageId;
	private Integer rentalDuration;
	private BigDecimal rentalRate;
	private Integer length;
	private BigDecimal replacementCost;
	private String rating;
	private String specialFeatures;

	public Film(Long id, String title, String description, Date releaseYear, Integer languageId, Integer rentalDuration,
			BigDecimal rentalRate, Integer length, BigDecimal replacementCost, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public Integer getRentalDuration() {
		return rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

}
