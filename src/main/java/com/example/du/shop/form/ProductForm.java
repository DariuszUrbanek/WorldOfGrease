package com.example.du.shop.form;

import java.math.BigDecimal;

import com.example.du.shop.generated.Product;

public class ProductForm {
	private Integer prId;
	private String prName;
	private String prDescription;
	private String prPrice;
	private Integer prStock;

	public ProductForm() {
	};

	public ProductForm(Product product) {
		super();
		this.prId = product.getPrId();
		this.prName = product.getPrName();
		this.prDescription = product.getPrDescription();
		this.prPrice = product.getPrPrice().toString();
		this.prStock = product.getPrStock();
	}

	public Product convertToEntity() {
		Product target = new Product();
		target.setPrId(this.prId);
		target.setPrName(this.prName);
		target.setPrDescription(this.prDescription);
		target.setPrPrice(new BigDecimal(this.prPrice));
		target.setPrStock(this.prStock);

		return target;
	}

	public Integer getPrId() {
		return prId;
	}

	public void setPrId(Integer prId) {
		this.prId = prId;
	}

	public String getPrName() {
		return prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
	}

	public String getPrDescription() {
		return prDescription;
	}

	public void setPrDescription(String prDescription) {
		this.prDescription = prDescription;
	}

	public String getPrPrice() {
		return prPrice;
	}

	public void setPrPrice(String prPrice) {
		this.prPrice = prPrice;
	}

	public Integer getPrStock() {
		return prStock;
	}

	public void setPrStock(Integer prStock) {
		this.prStock = prStock;
	}

}
