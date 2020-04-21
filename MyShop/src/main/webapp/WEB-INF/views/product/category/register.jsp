<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>카테고리 등록</title>
</head>

<body>
<jsp:include page="../../includes/header.jsp"/>
  <!-- Page Content -->
	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-lg-9 my-5">			
				<form id="registerForm" action="/myshop/product/category/register" method="post">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
					<div class="form-group">
						<label class="small mb-1" for="categoryname">카테고리</label>
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
	</script>
  <jsp:include page="../../includes/footer.jsp"></jsp:include>
</body>

</html>
