<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>${product.name }</title>
</head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
<body>
	<jsp:include page="../includes/header.jsp" />
	<jsp:include page="../includes/productsidebar.jsp" />
	<!-- Page Content -->
	<div class="col-lg-9 row justify-content-center ">
		<img src="${product.src }" width="300px">
		<table class="table table-borderless text-center">
			<tr>
				<th>상품명 : ${product.name }</th>
			</tr>
			<tr>
				<th>가격 : ${product.price } <i class="fas fa-won-sign"></i>
				</th>
			</tr>
			<tr>
			<sec:authorize access="hasRole('ROLE_USER')">
				<c:if test="${product.stock > 0 }">
				<td>					
					<div class="form-group">
						<label class="small mb-1" for="stock">갯수</label><br>
						<select id="stock" name="stock" data-width="fit" data-size="5" class="selectpicker">
						<c:forEach var="i" begin="1" end="${product.stock }">
							<option value="${i }">${i }</option>
						</c:forEach>
						</select>
					</div>
				</td>
				</c:if>
				<c:if test="${product.stock == 0 }">
				<td>
					<p class="text-danger">품절</p>
				</td>
				</c:if>
				</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN') or isAnonymous()">
					<c:if test="${product.stock > 0 }">					
					<th> 재고 : ${product.stock }개</th>
					</c:if>
					<c:if test="${product.stock <= 0 }">					
					<td>
						<p class="text-danger">품절</p>
					</td>
					</c:if>
					</sec:authorize>
				</tr>
			</table>
		<sec:authorize access="hasRole('ROLE_USER')">
		<c:if test="${product.stock > 0 }">		
		<form id="cartForm" action="/myshop/product/cart/add" method="post">
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
			<input type="hidden" id="productid" name="productid" value="${product.id }">
			<input type="hidden" id="userid" name="userid" value='<sec:authentication property="principal.username"/>'>			
			<input type="hidden" id="amount" name="amount">
		</form>
		<div class="row">
			<div class="form-group justify-content-center">
				<button type="button" class="btn btn-outline-primary btn-block"
					id="btnCart">장바구니 담기</button>
			</div>
		</div>		
		</c:if>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div class="row">
			<div class="form-group justify-content-center">
				<a href="/myshop/product/update?id=${product.id }" class="btn btn-outline-primary btn-block">상품 관리</a>
			</div>
		</div>
		</sec:authorize>
	</div>
	<!-- /.col-lg-9  -->
	</div>
	<!-- /.row  -->
	</div>
	<!-- /.container -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
	<script type="text/javascript">
		$(function() {
			var csrfHeaderName = "${_csrf.headerName}";
			var csrfTokenValue = "${_csrf.token}";

			$(document).ajaxSend(function(e, xhr, options){
				xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
			});

			$("#btnCart").on("click", function() {
				var userid = $("#userid").val();
				var productid = $("#productid").val();
						
				$.ajax({
					type : "get",
					url : "/myshop/product/cart/check",
					data : {				
					"userid" : userid,
					"productid" : productid
				},
				success : function(data) {
					if(data == 'NO'){
						alert("같은 상품이 이미 장바구니에 있습니다");
						return false;
						}
			 		$("#amount").val($("#stock").val());															
					$("#cartForm").submit();	
					alert("장바구니에 등록되었습니다");	
				}
				});
 
			});
		})
	</script>
</body>

</html>


