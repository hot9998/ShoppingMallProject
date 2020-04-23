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

<title>주문내역</title>
</head>
<body>
	<jsp:include page="../includes/header.jsp" />
	<jsp:include page="../includes/usersidebar.jsp" />
	<div class="col-lg-9">
		<h1 class="my-5 text-center">주문내역</h1>
		<table class="table">
			<tr>
				<th>주문번호</th>
				<th>주문일</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>주문승인결과</th>				
			</tr>
			<c:forEach items="${orderlist }" var="orderlist">
			<tr>
				<td><a href="/myshop/product/order/get?ordercode=${orderlist.ordercode }">${orderlist.orderid }</a></td>
				<td><fmt:formatDate value="${orderlist.orderdate }"/> </td>
				<td>${orderlist.addr }</td>
				<td>${orderlist.tel }</td>
				<c:if test="${orderlist.approval eq 0 }">
				<td>승인안됨</td>
				</c:if>
				<c:if test="${orderlist.approval eq 1 }">
				<td>처리완료</td>
				</c:if>
			</tr>
			</c:forEach>
		</table>				
	</div>
	<!-- /.col-lg-9 -->
	</div>
	<!-- /.row -->
	</div>	
	<!-- /.container -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>

<script type="text/javascript">
</script>
</body>

</html>


