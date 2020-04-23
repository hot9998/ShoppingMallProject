package com.myshop.domain;

import lombok.Data;

@Data
public class CartVO {
	private int cartid;
	private String userid;
	private int productid;
	private String productname;
	private int productprice;
	private int amount;
	private String src;
	private int stock;
}
