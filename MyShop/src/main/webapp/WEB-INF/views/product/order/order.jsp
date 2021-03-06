<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>주문하기</title>
</head>
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
<body>
	<jsp:include page="../../includes/header.jsp" />
	<jsp:include page="../../includes/usersidebar.jsp" />
	<div class="col-lg-9">
		<h1 class="my-5 text-center">주문하기</h1>
		<table class="table">
			<tr>
				<th>상품 이미지</th>
				<th>상품명</th>
				<th>가격</th>
				<th>갯수</th>
				<th>총액</th>
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
					<td>${cartlist.productprice*cartlist.amount } <i class="fas fa-won-sign"></i></td>
				</tr>
			</c:forEach>
		</table>	
		<form id="orderForm" action="/myshop/product/order" method="post">
	            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	            <input type="hidden" name="userid" value='<sec:authentication property="principal.username"/>'>
	            <input type="hidden" name="addr" id="orderAddr">
   	                <div class="form-group">
		                <label class="small mb-1" for="orderName">주문자명</label>
		                <input class="form-control" id="orderName" name="ordername" type="text" />
	                </div>
	                <div class="form-group">
		                <label class="small mb-1" for="orderTel">휴대전화</label>
		                <input class="form-control" name="tel" id="orderTel" type="tel" maxlength="13" placeholder="전화번호를 입력하세요" />
	                </div>
					<div class="form-group">
						<label class="small mb-1">우편번호</label>
						<input class="form-control" style="width: 30%" type="text" id="orderZipcode" readonly="readonly">
					</div>						
					<div class="form-group">
						<label class="small mb-1">배송 주소지</label>
						<div class="input-group">
							<input class="form-control input-group-prepend joinInput" type="text" id="orderAddrView" readonly="readonly">
							<button type="button" id="orderAddrBtn" class="btn btn-outline-primary input-group-apeend">주소 검색</button>
						</div>
					</div>
  	                <div class="form-group">
		                <label class="small mb-1" for="orderAddrDetail">상세주소</label>
		                <input class="form-control" id="orderAddrDetail" type="text" placeholder="상세주소를 입력하세요" />
	                </div>
          	</form>
		<div class="text-right">			
			<button type="button" id="btnOrder" class="btn btn-outline-primary">주문하기</button>			
		</div>
				
	</div>
	<!-- /.col-lg-9 -->
	</div>
	<!-- /.row -->
	</div>	
	<!-- /.container -->
	<jsp:include page="../../includes/footer.jsp"></jsp:include>

<script type="text/javascript">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
<script>
	// 카카오 주소 API 팝업
	$(function(){
		var regtel = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
		$("#btnOrder").on("click",function(){
			if($("#orderName").val()==""){
				alert("주문자명을 입력하세요");
				$("#orderName").focus();
				return false;
				}
			if($("#orderTel").val()==""){
				alert("전화번호를 입력하세요");
				$("#orderTel").focus();
				return false;
				}
			if($("#orderAddrView").val()==""){
				alert("주소를 검색하세요");
				return false;
				}
			if($("#orderAddrDetail").val()==""){
				alert("상세주소를 입력하세요");
				$("#orderAddrDetail").focus();
				return false;
				}
			if(!regtel.exec($("#orderTel").val())){
				alert("전화번호 양식이 틀렸습니다");
				$("#orderTel").val("");
				$("#orderTel").focus();
				return false;
			}
			var userid = '<sec:authentication property="principal.username"/>';
			$.get("/myshop/product/cart/stock",
					{"userid" : userid},
					function(data){
						if(data == "YES"){
							alert('제품의 수량이 부족하여 주문이 불가능합니다');
							return false;			
							}
						}
					)
					
			var addr = $("#orderAddrView").val() + " " + $("#orderAddrDetail").val();
			$("#orderAddr").val(addr);		
			$("#orderForm").submit();
			alert("상품 주문이 완료되었습니다");
			})
		
		$("#orderAddrBtn").on("click", function() {
				new daum.Postcode(
						{
							oncomplete : function(data) {
								// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

								// 각 주소의 노출 규칙에 따라 주소를 조합한다.
								// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기
								// 한다.
								var addr = ''; // 주소 변수
								var extraAddr = ''; // 참고항목 변수

								// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
								if (data.userSelectedType === 'R') { // 사용자가
																		// 도로명
																		// 주소를
																		// 선택했을
																		// 경우
									addr = data.roadAddress;
								} else { // 사용자가 지번 주소를 선택했을 경우(J)
									addr = data.jibunAddress;
								}

								// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
								if (data.userSelectedType === 'R') {
									// 법정동명이 있을 경우 추가한다. (법정리는 제외)
									// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
									if (data.bname !== ''
											&& /[동|로|가]$/g.test(data.bname)) {
										extraAddr += data.bname;
									}
									// 건물명이 있고, 공동주택일 경우 추가한다.
									if (data.buildingName !== ''
											&& data.apartment === 'Y') {
										extraAddr += (extraAddr !== '' ? ', '
												+ data.buildingName
												: data.buildingName);
									}
									// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
									if (extraAddr !== '') {
										extraAddr = ' (' + extraAddr + ')';
									}
									// 조합된 참고항목을 해당 필드에 넣는다.
									// document.getElementById("sample6_extraAddress").value
									// = extraAddr;

								} else {
									// document.getElementById("sample6_extraAddress").value
									// = '';
								}

								// 우편번호와 주소 정보를 해당 필드에 넣는다.
								$("#orderZipcode").val(data.zonecode);
								$("#orderAddrView").val(addr);
								// 커서를 상세주소 필드로 이동한다.
								$("#updateAddrDetail").focus();
							}
						}).open();
			});
		//전화번호 자동 하이픈
		$('#orderTel').keydown(function(event) {
	    var key = event.charCode || event.keyCode || 0;
	    $text = $(this);
	    if (key !== 8 && key !== 9) {
	        if ($text.val().length === 3) {
	            $text.val($text.val() + '-');
	        }
	        if ($text.val().length === 8) {
	            $text.val($text.val() + '-');
	        }
	    }
		});
		
	});
</script>
</body>

</html>

