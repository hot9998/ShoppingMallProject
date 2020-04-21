package com.myshop.service;

import java.util.List;

import com.myshop.domain.ProductVO;

public interface ProductService {
	public void categoryRegister(String categoryname);
	public List<String> categorylist();
	public void categoryDelete(String categoryname);
	public void productRegister(ProductVO product);
	public List<ProductVO> ProductList();

}
