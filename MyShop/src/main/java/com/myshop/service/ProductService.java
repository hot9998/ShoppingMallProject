package com.myshop.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myshop.domain.CartVO;
import com.myshop.domain.OrderVO;
import com.myshop.domain.ProductVO;

public interface ProductService {
	public void categoryRegister(String categoryname);
	public List<String> categorylist();
	public void categoryDelete(String categoryname);
	
	public void productRegister(ProductVO product);
	public List<ProductVO> productList(String category);
	public ProductVO productGet(int id);
	public void productUpdate(ProductVO product);
	public void productDelete(int id);
	
	public void cartAdd(CartVO cart);
	public List<CartVO> cartList(String userid);
	public void cartDelete(int cartid);
	public void cartDeleteById(String userid);
	public void cartAmount(@Param("cartid") int cartid, @Param("amount") int amount);
	public CartVO cartGet(int cartid);

	public void order(OrderVO order, CartVO cart);
	public List<OrderVO> orderList();
	public List<OrderVO> orderListByCode(String ordercode);
	public List<OrderVO> orderListById(String userid);
	public void orderCancel(String ordercode);
	public void orderCancelAmount(int productid, int amount);
	public void orderApproval(String ordercode);
	
	
	
	
}
