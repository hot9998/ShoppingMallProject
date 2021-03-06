<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>주문 내역</title>
</head>
<body>
	<jsp:include page="../../includes/header.jsp" />
	<jsp:include page="../../includes/usersidebar.jsp" />
	<div class="col-lg-9">
		<h1 class="my-5 text-center">주문 내역</h1>
		<div class="text-right">
		<p>주문자명 : ${orderlist[0].ordername }</p>
		<p>전화번호 : ${orderlist[0].tel }</p>
		<p>배송 주소지 : ${orderlist[0].addr }</p>
		<p>총액 : ${total } <i class="fas fa-won-sign"></i></p>	
		<p>주문 처리 상태 : ${orderlist[0].approval }</p>
		</div>
		<table class="table">		
			<tr>
				<th>상품 이미지</th>
				<th>상품명</th>
				<th>가격</th>
				<th>갯수</th>
				<th>총액</th>			
			</tr>
			<c:forEach items="${orderlist }" var="orderlist">
			<tr>
				<td><img alt="" src="${orderlist.src }" width="100px"></td>
				<td>${orderlist.productname }</td>
				<td>${orderlist.productprice } <i class="fas fa-won-sign"></i></td>
				<td>${orderlist.amount }</td>
				<td>${orderlist.productprice*orderlist.amount } <i class="fas fa-won-sign"></i></td>
							
			</tr>
			</c:forEach>
		</table>
	
	</div>
	<!-- /.col-lg-9 -->	
	</div>
	<!-- /.row -->
	<c:if test="${orderlist[0].approval eq '승인안됨' }">
	<div class="text-right mb-5">
		<button id="btnCancel" type="button" class="btn btn-outline-danger">주문취소</button>
	</div>
	</c:if>
	</div>	
	<!-- /.container -->
	<jsp:include page="../../includes/footer.jsp"></jsp:include>

<script type="text/javascript">
	$(function(){
		$("#btnCancel").on("click",function(){
			if(confirm("정말 주문을 취소하시겠습니까?")){
				location.href = "/myshop/product/order/cancel?ordercode=${orderlist[0].ordercode}&userid=${orderlist[0].userid }"
				alert("주문이 취소되었습니다");
				}
			})				
	})
</script>
</body>

</html>




