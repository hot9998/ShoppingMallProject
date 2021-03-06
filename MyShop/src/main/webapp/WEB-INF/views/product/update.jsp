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
	<title>상품 정보 수정</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
<body>
<jsp:include page="../includes/header.jsp"/>
  <!-- Page Content -->
	<div class="container my-5">
		<div class="row justify-content-center" style="min-height: 1000px">
			<div class="col-lg-9 my-5">
			<div class="text-center">
			<h1>상품 수정</h1>
			<img id="productimg" width="300px" src="${product.src }">
			</div>
				<form id="updateForm" action="/myshop/product/update" method="post" enctype="multipart/form-data">
					<input type="hidden" id="imgModify" name="imgModify" value="0">
					<input type="hidden" name="src" value="${product.src }">
					<input type="hidden" name="id" value="${product.id }">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
					<div class="form-group">
						<label class="small mb-1" for="name">상품명</label>
						<input class="form-control py-4" name="name" id="name" value="${product.name }" type="text" placeholder="상품명을 입력하세요" />
					</div>
					<div class="form-group">
						<label class="small mb-1" for="price">가격</label>
						<input class="form-control py-4" name="price" id="price" value="${product.price }" type="text" placeholder="가격을 입력하세요" />
					</div>
					<div class="form-group">
						<label class="small mb-1" for="stock">재고</label>
						<input class="form-control py-4" name="stock" id="stock" value="${product.stock }" type="text" placeholder="재고를 입력하세요" />
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
								<button type="button" class="btn btn-outline-primary btn-block" id="btnRegister">상품수정</button>
							</div>
							<div class="col-md-2">
								<button type="button" class="btn btn-outline-danger btn-block" id="btnDelete">상품삭제</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /.container -->
	<script type="text/javascript">
		//	숫자만 입력
		$("#price").on("blur keyup",function(){
			$(this).val($(this).val().replace(/[^0-9]/gi,''));
		})	
		$("#stock").on("blur keyup",function(){
			$(this).val($(this).val().replace(/[^0-9]/gi,''));
		})	
		$("#file").on("change",function(){
			var fileName = $(this).val();
			$(this).next("#filelabel").html(fileName);
			$("#imgModify").val('1');			
		})
		$("#file").change(function(){
			if(this.files && this.files[0]){
				var reader = new FileReader;
				reader.onload = function(data){
					$("#productimg").attr("src",data.target.result);
					}
				reader.readAsDataURL(this.files[0]);
				}
			})
	$(function(){
		$("#btnRegister").on("click",function(){
			if($("#name").val()==""){
				alert("상품명을 입력하세요");
				$("#name").focus();
				return false;
				}
			if($("#price").val()==""){
				alert("가격을 입력하세요");
				$("#price").focus();
				return false;
				}
			if($("#stock").val()==""){
				alert("재고를 입력하세요");
				$("#stock").focus();
				return false;
				}
			if($("#price").val() <= 0){
				alert("가격은 1이상의 값을 입력해주세요");
				$("#price").val("");
				$("#price").focus();
				return false;
				}
			if($("#stock").val() < 0){
				alert("재고는 0이상의 값을 입력해주세요");
				$("#stock").val("");
				$("#stock").focus();
				return false;
				}
			alert("상품 정보가 성공적으로 변경되었습니다");
			$("#updateForm").submit();
			});
		$("#btnDelete").on("click",function(){
			if(confirm("정말 물품을 삭제하시겠습니까?")){
				location.href = "/myshop/product/delete?id=${product.id}";				
				}
			})
		})
		
		// 카테고리 체크
		var categoryname = "${product.categoryname}";		
		$("#categoryname option").each(function(){
			if(categoryname == $(this).val()){
				$(this).prop("selected",true);
				}
		});
		
	</script>
  <jsp:include page="../includes/footer.jsp"></jsp:include>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
</body>
</html>
