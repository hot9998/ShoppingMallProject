<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>카테고리 리스트</title>
</head>
<body>
	<jsp:include page="../../includes/header.jsp" />
	<!-- Page Content -->
	<div class="container my-5 text-center justify-content-center" style="min-height: 1000px">
	<h1 class="my-5">카테고리 관리</h1>
		<div class="card my-5">
			<div class="card-header">
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable">
							<thead>
								<tr>
									<th style="width: 80%">카테고리명</th>
									<th>삭제</th>
								</tr>
								<c:forEach items="${list }" var="list">
									<tr>
										<td>${list }</td>
										<td>
										<a href="javascript:categoryDelete('${list }')">삭제</a>
										</td>										
									</tr>
								</c:forEach>
							</thead>
						</table>
					</div>
					<form id="registerForm" action="/myshop/product/category/register" method="post">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
					<div class="form-group">
						<label class="mb-1" for="categoryname">카테고리 등록</label>
						<input class="form-control py-4" name="categoryname" id="categoryname" type="text"
							placeholder="카테고리 이름을 입력하세요" />
					</div>
					<div class="form-group mt-4 mb-0">
						<div class="form-row justify-content-center">
							<div class="col-md-2">
								<button type="button" class="btn btn-outline-primary btn-block" id="btnRegister">등록</button>
							</div>
						</div>
					</div>
				</form>
				</div>
			</div>

		</div>
	</div>
	<!-- /.container -->
	<script type="text/javascript">
		$(function() {
			$("#btnRegister").on("click", function() {
				if ($("#categoryname").val() == "") {
					alert("카테고리 이름을 입력하세요");
					$("#categoryname").focus();
					return false;
				}
				$("#registerForm").submit();
			});
		});
		function categoryDelete(categoryname) {
			if (confirm("정말 삭제 하시겠습니까?")) {
				location.href = "/myshop/product/category/delete?categoryname="
						+ categoryname;
			}
		}
	</script>

	<jsp:include page="../../includes/footer.jsp"></jsp:include>
</body>

</html>
