package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.domain.ProductVO;
import com.myshop.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductMapper mapper;

	@Override
	public void categoryRegister(String categoryname) {
		// TODO Auto-generated method stub
		mapper.categoryRegister(categoryname);
	}

	@Override
	public List<String> categorylist() {
		// TODO Auto-generated method stub
		return mapper.categorylist();
	}

	@Override
	public void categoryDelete(String categoryname) {
		// TODO Auto-generated method stub
		mapper.categoryDelete(categoryname);
	}

	@Override
	public void productRegister(ProductVO product) {
		// TODO Auto-generated method stub
		mapper.productRegister(product);
	}

	@Override
	public List<ProductVO> ProductList() {
		// TODO Auto-generated method stub
		return mapper.ProductList();
	}
	
}
