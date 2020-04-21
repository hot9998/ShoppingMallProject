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
	<title>상품등록</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
<body>
<jsp:include page="../includes/header.jsp"/>
  <!-- Page Content -->
	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-lg-9 my-5">			
				<form id="registerForm" action="/myshop/product/register" method="post" enctype="multipart/form-data">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
					<div class="form-group">
						<label class="small mb-1" for="name">상품명</label>
						<input class="form-control py-4" name="name" id="name" type="text" placeholder="상품명을 입력하세요" />
					</div>
					<div class="form-group">
						<label class="small mb-1" for="price">가격</label>
						<input class="form-control py-4" name="price" id="price" type="text" placeholder="가격을 입력하세요" />
					</div>
					<div class="form-group">
						<label class="small mb-1" for="stock">재고</label>
						<input class="form-control py-4" name="stock" id="stock" type="text" placeholder="재고를 입력하세요" />
					</div>
					<div class="form-group">
						<label class="small mb-1" for="file">상품 이미지</label>
						<div class="custom-file">
						 <input type="file" accept="image/*" class="custom-file-input" id="file" name="file">
						<label id="filelabel" class="custom-file-label" for="file">Choose file</label>
						</div>
					</div>
					<div class="form-group">
						<label class="small mb-1" for="categoryname">카테고리</label><br>
						<select id="categoryname" name="categoryname" class="selectpicker">
							<c:forEach items="${categorys }" var="categorys">
								<option value="${categorys }">${categorys }</option>
							</c:forEach>
						</select>												
					</div>
					<div class="form-group mt-4 mb-0">
						<div class="form-row justify-content-center">
							<div class="col-md-2">
								<button type="button" class="btn btn-outline-primary btn-block" id="btnRegister">상품등록</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /.container -->
	<script type="text/javascript">
	// 	숫자만 입력
		$("#price").on("blur keyup",function(){
			$(this).val($(this).val().replace(/[^0-9]/gi,''));
		})	
		$("#stock").on("blur keyup",function(){
			$(this).val($(this).val().replace(/[^0-9]/gi,''));
		})	
		$("#file").on("change",function(){
			var fileName = $(this).val();
			$(this).next("#filelabel").html(fileName);
		})
	$(function(){
		$("#btnRegister").on("click",function(){
			$("#registerForm").submit();
			});
		})
	</script>
  <jsp:include page="../includes/footer.jsp"></jsp:include>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
</body>
</html>