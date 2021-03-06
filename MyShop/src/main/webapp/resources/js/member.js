//회원가입 폼
function join() {
	$(".joinInput").val("");
	$("#joinModal").modal("show");
	$("#joinid").removeAttr("readonly");
	$("#idcheck").val("0");
}
//로그인 폼
function login() {
	$("#loginid").val("");
	$("#loginpw").val("");
	$("#loginModal").modal("show");
}
//로그아웃 버튼
function logout(){
	alert("로그아웃 되었습니다");
	$("#logoutForm").submit();	
}

$(function() {
//	이메일 정규식
var regemail=/^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;
var regtel = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;

//	아이디 한글 입력 방지
	$("#joinid").on("blur keyup",function(){
		$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g,''));
	})
	$("#loginid").on("blur keyup",function(){
		$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g,''));
	})
//	전화번호 자동 하이픈
	$('#tel').keydown(function(event) {
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
	 
	    return (key == 8 || key == 9 || key == 46 || (key >= 48 && key <= 57) || (key >= 96 && key <= 105));          
	});

//	이름 한글만 입력
	$("#username").on("blur keyup",function(){
		$(this).val($(this).val().replace(/[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g,''));
	})
	
	// 회원가입
	$("#joinBtn").on("click", function() {
		if ($("#joinnid").val() == "") {
			alert("아이디를 입력하세요");
			$("#joinnid").focus();
			return false;
		}
		if ($("#joinpw").val() == "") {
			alert("패스워드를 입력하세요");
			$("#joinpw").focus();
			return false;
		}
		if ($("#pwdcheck").val() == "") {
			alert("패스워드 확인을 입력하세요");
			$("#pwdcheck").focus();
			return false;
		}
		if ($("#username").val() == "") {
			alert("이름을 입력하세요");
			$("#username").focus();
			return false;
		}
		if ($("#tel").val() == "") {
			alert("전화번호를 입력하세요");
			$("#tel").focus();
			return false;
		}
		if ($("#email").val() == "") {
			alert("이메일을 입력하세요");
			$("#email").focus();
			return false;
		}
		if ($("#addrView").val() == "") {
			alert("주소를 검색하세요");
			return false;
		}
		if ($("#addrDetail").val() == "") {
			alert("상세주소를 입력하세요");
			$("#addrDetail").focus();
			return false;
		}
		
		if ($("#idcheck").val() == "0") {
			alert("아이디 중복체크를 하세요");
			return false;
		}
		if ($("#joinpw").val() != $("#pwdcheck").val()) {
			alert("패스워드가 틀렸습니다");
			$("#joinpw").val("");
			$("#pwdcheck").val("");
			$("#joinpw").focus();
			return false;
		}
		if(!regtel.exec($("#tel").val())){
			alert("전화번호 양식이 틀렸습니다");
			$("#tel").val("");
			$("#tel").focus();
			return false;
		}
		if(!regemail.exec($("#email").val())){
			alert("이메일 양식이 틀렸습니다");
			$("#email").val("");
			$("#email").focus();
			return false;
		}

		var addr = $("#addrView").val() + " " + $("#addrDetail").val();
		$("#addr").val(addr);

		$("#joinForm").submit();
		alert("회원가입이 완료 되었습니다!");
	});

	$("#idcheckBtn").click(function() {
		if ($("#joinid").val() == "") {
			alert("ID를 입력해주세요");
			$("#registerid").focus();
			return false;
		}
		if ($("#idcheck").val() == "1") {
			$("#joinid").removeAttr("readonly");
			$("#joinid").val("");
			$("#idcheck").val("0");
			return false;
		}
		$.get("/myshop/user/idcheck", {
			"userid" : $("#joinid").val()
		}, function(data) {
			if (data == "no"){
				alert("이미 가입된 아이디 입니다");
				$("#joinid").val("");
				$("#joinid").focus();
			}
			if (data == "yes") {
				alert("사용 가능한 아이디 입니다");
				$("#joinid").attr("readonly", "readonly");
				$("#idcheck").val("1");				
			}
			

		})
	});

	// 카카오 주소 API 팝업
	$("#addrBtn").on(
			"click",
			function() {
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
								$("#zipcode").val(data.zonecode);
								$("#addrView").val(addr);
								// 커서를 상세주소 필드로 이동한다.
								$("#addrDetail").focus();
							}
						}).open();
			});

	// 로그인
	$("#loginBtn").on("click", function() {
		if ($("#loginid").val() == "") {
			alert("아이디를 입력하세요");
			$("#loginid").focus();
			return false;
		}
		if ($("#loginpw").val() == "") {
			alert("패스워드를 입력하세요");
			$("#loginpw").focus();
			return false;
		}
		$("#loginForm").submit();
	});

})