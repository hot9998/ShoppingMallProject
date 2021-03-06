package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.domain.CartVO;
import com.myshop.domain.OrderVO;
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
	@Transactional
	public void categoryDelete(String categoryname) {
		// TODO Auto-generated method stub
		mapper.productDeleteByCategory(categoryname);
		mapper.categoryDelete(categoryname);
	}

	@Override
	public void productRegister(ProductVO product) {
		// TODO Auto-generated method stub
		mapper.productRegister(product);
	}

	@Override
	public List<ProductVO> productList(String category) {
		// TODO Auto-generated method stub
		return mapper.productList(category);
	}

	@Override
	public ProductVO productGet(int id) {
		// TODO Auto-generated method stub
		return mapper.productGet(id);
	}

	@Override
	public void productUpdate(ProductVO product) {
		// TODO Auto-generated method stub
		mapper.productUpdate(product);
	}

	@Override
	@Transactional
	public void productDelete(int id) {
		// TODO Auto-generated method stub
		mapper.cartDeleteByProductid(id);
		mapper.productDelete(id);
	}

	@Override
	public void cartAdd(CartVO cart) {
		// TODO Auto-generated method stub
		mapper.cartAdd(cart);
	}

	@Override
	public List<CartVO> cartList(String userid) {
		// TODO Auto-generated method stub
		return mapper.cartList(userid);
	}

	@Override
	public void cartDelete(int cartid) {
		// TODO Auto-generated method stub
		mapper.cartDelete(cartid);

	}

	@Override
	public void cartDeleteById(String userid) {
		// TODO Auto-generated method stub
		mapper.cartDeleteById(userid);
	}

	@Override
	public void cartAmount(int cartid, int amount) {
		// TODO Auto-generated method stub
		mapper.cartAmount(cartid, amount);
	}
	
	@Override
	public CartVO cartGet(int cartid) {
		// TODO Auto-generated method stub
		return mapper.cartGet(cartid);
	}

	@Override
	@Transactional
	public void order(OrderVO order, CartVO cart) {
		// TODO Auto-generated method stub
		mapper.order(order);
		mapper.orderAmount(cart);
	}

	@Override
	public List<OrderVO> orderListById(String userid) {
		// TODO Auto-generated method stub
		return mapper.orderListById(userid);
	}

	@Override
	public List<OrderVO> orderListByCode(String ordercode) {
		// TODO Auto-generated method stub
		return mapper.orderListByCode(ordercode);
	}

	@Override
	public List<OrderVO> orderList() {
		// TODO Auto-generated method stub
		return mapper.orderList();
	}

	@Override
	public void orderCancel(String ordercode) {
		// TODO Auto-generated method stub
		mapper.orderCancel(ordercode);

	}

	@Override
	public void orderCancelAmount(int productid, int amount) {
		// TODO Auto-generated method stub
		mapper.orderCancelAmount(productid, amount);
	}

	@Override
	public void orderApproval(String ordercode) {
		// TODO Auto-generated method stub
		mapper.orderApproval(ordercode);		
	}



	

}
