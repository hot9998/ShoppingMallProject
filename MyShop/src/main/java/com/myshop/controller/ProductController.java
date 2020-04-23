package com.myshop.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myshop.domain.CartVO;
import com.myshop.domain.OrderVO;
import com.myshop.domain.ProductVO;
import com.myshop.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	@Autowired
	ProductService service;
	@Resource(name = "uploadPath")
	String uploadPath;

//	���� ������
	@GetMapping("/home")
	public void home(String category, Model model) {
		List<String> categorys = service.categorylist();
		List<ProductVO> products = service.productList(category);
		model.addAttribute("categorys", categorys);
		model.addAttribute("products", products);
	}

//	ī�װ��� ����Ʈ
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/category/list")
	public void categorylist(Model model) {
		List<String> list = service.categorylist();
		model.addAttribute("list", list);
	}

//	ī�װ��� ��� ������
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/category/register")
	public void categoryRegister() {
	}

//	ī�װ��� ���
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/category/register")
	public String categoryRegister(String categoryname) {
		service.categoryRegister(categoryname);
		return "redirect:/product/category/list";
	}

//	ī�װ��� ����
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/category/delete")
	public String categoryDelete(String categoryname) {
		service.categoryDelete(categoryname);
		return "redirect:/product/category/list";
	}

//	��ǰ ���  ������
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/register")
	public void register(Model model) {
		List<String> categorys = service.categorylist();
		model.addAttribute("categorys", categorys);
	}

//	��ǰ ���
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/register")
	public String productRegister(ProductVO product) throws Exception {
		// ���� ��ο� ���ϸ� ����
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString() + product.getFile().getOriginalFilename();
		File target = new File(uploadPath, savedName);
		// ���� ������ �޾ƿͼ� ���ε�
		FileCopyUtils.copy(product.getFile().getBytes(), target);

		// ���� ��� ����
		product.setSrc("/myshop/resources/img/" + savedName);
		// ���ϸ� ����
		product.setImgname(savedName);

		service.productRegister(product);
		return "redirect:/";
	}

//	��ǰ ���� ������
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/update")
	public void productUpdate(int id, Model model) {
		List<String> categorys = service.categorylist();
		ProductVO product = service.productGet(id);
		model.addAttribute("product", product);
		model.addAttribute("categorys", categorys);
	}

//	��ǰ ����
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public String productUpdate(ProductVO product, String imgModify) throws Exception {

		if (imgModify.equals("1")) {
			UUID uuid = UUID.randomUUID();
			String savedName = uuid.toString() + product.getFile().getOriginalFilename();
			File target = new File(uploadPath, savedName);

			FileCopyUtils.copy(product.getFile().getBytes(), target);

			product.setSrc("/myshop/resources/img/" + savedName);
//		System.out.println(product.getSrc());
//		System.out.println(product.getFile());
		}

		service.productUpdate(product);
		return "redirect:/";
	}

//	��ǰ ����
	@GetMapping("/get")
	public void get(int id, Model model) {
		List<String> categorys = service.categorylist();
		ProductVO product = service.productGet(id);
		model.addAttribute("categorys", categorys);
		model.addAttribute("product", product);
	}

//	��ǰ ����	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete")
	public String productDelete(int id) {

		ProductVO product = service.productGet(id);

		File file = new File(uploadPath + "/" + product.getImgname());

		// ��ο��� �̹��� ���� ����
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("���ϻ��� ����");
			} else {
				System.out.println("���ϻ��� ����");
			}
		}

		service.productDelete(id);

		return "redirect:/";
	}

//	��ٱ��� �߰�
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/cart/add")
	public String cartAdd(CartVO cart) {
		service.cartAdd(cart);

		return "redirect:/";
	}

//	��ٱ��� üũ
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/cart/check")
	@ResponseBody
	public String cartCheck(String userid, int productid) {
//		System.out.println(userid);
//		System.out.println(productid);
		List<CartVO> cartlist = service.cartList(userid);

		String str = "YES";
		for (int i = 0; i < cartlist.size(); i++) {
			if (cartlist.get(i).getProductid() == productid) {
//				System.out.println("���� ��ǰ�� �̹� ��ϵ�");
				str = "NO";
			}
		}
		return str;
	}

//	��ٱ��� ����
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/cart")
	public void cart(String userid, Model model) {
		List<CartVO> cartlist = service.cartList(userid);

		model.addAttribute("cartlist", cartlist);
	}

//	��ٱ��� ����
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/cart/delete")
	public String cartDelete(String userid, int cartid) {
		service.cartDelete(cartid);

		return "redirect:/product/cart?userid=" + userid;
	}

//	��ٱ��� ����
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/cart/deleteById")
	public String cartDeleteById(String userid) {
		service.cartDeleteById(userid);

		return "redirect:/product/cart?userid=" + userid;
	}

//	��ٱ��� ���� ����
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/cart/amount")
	public String cartAmount(int cartid, int amount, String userid) {
		service.cartAmount(cartid, amount);
		return "redirect:/product/cart?userid=" + userid;
	}

//	�ֹ� ������
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/order")
	public void order(String userid, Model model) {
		List<CartVO> cartlist = service.cartList(userid);

		model.addAttribute("cartlist", cartlist);
	}

//	��ǰ �ֹ�
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/order")
	public String order(OrderVO order) {
		List<CartVO> cartlist = service.cartList(order.getUserid());
		UUID ordercode = UUID.randomUUID();
		order.setOrdercode(ordercode.toString());

		for (int i = 0; i < cartlist.size(); i++) {
			order.setProductname(cartlist.get(i).getProductname());
			order.setProductprice(cartlist.get(i).getProductprice());
			order.setSrc(cartlist.get(i).getSrc());
			order.setAmount(cartlist.get(i).getAmount());
			service.order(order, cartlist.get(i));
		}

		service.cartDeleteById(order.getUserid());

		return "redirect:/";
	}

//	�ֹ� ����Ʈ
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/order/list")
	public String orderListById(String userid, Model model) {
		
		List<OrderVO> orderlist = service.orderListById(userid);

		model.addAttribute("orderlist", orderlist);
		

		return "/product/orderlist";
	}

//	�ֹ� ��������
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/order/get")
	public String orderGet(String ordercode, Model model) {
		List<OrderVO> orderlist = service.orderListByCode(ordercode);
		
		int total = 0;
		for (int i = 0; i < orderlist.size(); i++) {
			total = total + (orderlist.get(i).getAmount() * orderlist.get(i).getProductprice());
		}

		
		model.addAttribute("total", total);
		model.addAttribute("orderlist", orderlist);

		return "/product/orderget";
	}

}