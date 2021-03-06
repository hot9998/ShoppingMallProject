<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>장바구니</title>
</head>
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
<body>
	<jsp:include page="../includes/header.jsp" />
	<jsp:include page="../includes/usersidebar.jsp" />
	<div class="col-lg-9">
			<c:if test="${fn:length(cartlist) <= 0 }">
			<div class="my-5 text-center">
				<h1>장바구니가 비었습니다</h1>
			</div>
			</c:if>
		<c:if test="${fn:length(cartlist) > 0 }">
		<h1 class="my-5 text-center">장바구니</h1>
		<table class="table">
			<tr>
				<th>상품 이미지</th>
				<th>상품명</th>
				<th>가격</th>
				<th>수량</th>
				<th>수량 수정</th>
				<th>총액</th>
				<th>삭제</th>
			</tr>

			<c:forEach items="${cartlist }" var="cartlist">
				<tr>
					<td>
					<a href="/myshop/product/get?id=${cartlist.productid }">
					<img alt="" src="${cartlist.src }" width="100px"></a>
					</td>
					<td><a href="/myshop/product/get?id=${cartlist.productid }">${cartlist.productname }</a></td>
					<td>${cartlist.productprice } <i class="fas fa-won-sign"></i></td>
					<td>${cartlist.amount }</td>
					<td>
						<form id="amountForm" action="/myshop/product/cart/amount" method="post">
							<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
							<input type="hidden" id="cartid" name="cartid">							
							<input type="hidden" name="userid" id="userid" value='<sec:authentication property="principal.username"/>'>
							<select id="amount" name="amount" id="amount" data-width="fit" class="selectpicker" data-size="5">
							<c:forEach var="i" begin="1" end="${cartlist.stock }">
								<option value="${i }">${i }</option>																
							</c:forEach>
							</select>
							<a href="javascript:cartAmount('${cartlist.cartid }')" class="btn btn-sm btn-outline-info">수정</a>
						</form>						
					</td>
					<td>${cartlist.productprice*cartlist.amount } <i class="fas fa-won-sign"></i></td>
					<td><a href="javascript:cartDelete('${cartlist.cartid }')">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="text-right">
			<a href="javascript:cartDeleteById()" class="btn btn-outline-danger">비우기</a>
			<a href="/myshop/product/order?userid=<sec:authentication property="principal.username"/>" class="btn btn-outline-primary">주문하기</a>			
		</div>		
		</c:if>
	</div>
	<!-- /.col-lg-9 -->
	</div>
	<!-- /.row -->
	</div>	
	<!-- /.container -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>

	<script type="text/javascript">
	$(function(){
		var userid = '<sec:authentication property="principal.username"/>';
		$.get("/myshop/product/cart/stock",
				{"userid" : userid},
				function(data){
					if(data == "YES"){
						alert('장바구니에 넣어둔 제품의 수량이 부족하여 \n 장바구니에서 제외되었습니다');
						location.href = "/myshop/product/cart?userid="+userid;						
						}
					}
				)
		})
	function cartAmount(cartid){
			$("#cartid").val(cartid);			
			$("#amountForm").submit();
			alert("갯수가 수정되었습니다");
		}	
	function cartDelete(cartid){	
		if(confirm("정말 해당 물품을 장바구니에서 삭제하시겠습니까?")){
			alert("해당 물품이 장바구니에서 삭제되었습니다");
			location.href = "/myshop/product/cart/delete?userid=<sec:authentication property="principal.username"/>&cartid="+cartid;
			}		
		}
	function cartDeleteById(){
		if(confirm("정말 장바구니를 비우시겠습니까?")){
			alert("장바구니를 비웠습니다");
			location.href = "/myshop/product/cart/deleteById?userid=<sec:authentication property='principal.username'/>";
		}
	}
	
	
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
</body>

</html>


