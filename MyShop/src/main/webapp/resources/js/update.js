$(function() {	
//	이메일 정규식
var regemail=/^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;
var regtel = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
	//전화번호 자동 하이픈
	$('#updateTel').keydown(function(event) {
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
	//이름 한글만 입력
	$("#updateUsername").on("blur keyup",function(){
		$(this).val($(this).val().replace(/[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g,''));
	})
	
	// 회원가입
	$("#updateBtn").on("click", function() {
		if ($("#updatePw").val() == "") {
			alert("패스워드를 입력하세요");
			$("#updatePw").focus();
			return false;
		}
		if ($("#updatePwdcheck").val() == "") {
			alert("패스워드 확인을 입력하세요");
			$("#pwdcheck").focus();
			return false;
		}
		if ($("#updateUsername").val() == "") {
			alert("이름을 입력하세요");
			$("#updateUsername").focus();
			return false;
		}
		if ($("#updateTel").val() == "") {
			alert("전화번호를 입력하세요");
			$("#updateTel").focus();
			return false;
		}
		if ($("#updateEmail").val() == "") {
			alert("이메일을 입력하세요");
			$("#updateEmail").focus();
			return false;
		}
		if ($("#updateAddrView").val() == "") {
			alert("주소를 검색하세요");
			return false;
		}
		if ($("#updateAddrDetail").val() == "") {
			alert("상세주소를 입력하세요");
			$("#updateAddrDetail").focus();
			return false;
		}
		if ($("#updatePw").val() != $("#updatePwdcheck").val()) {
			alert("패스워드가 틀렸습니다");
			$("#updatePw").val("");
			$("#updatePwdcheck").val("");
			$("#updatePw").focus();
			return false;
		}
		if(!regtel.exec($("#updateTel").val())){
			alert("전화번호 양식이 틀렸습니다");
			$("#updateTel").val("");
			$("#updateTel").focus();
			return false;
		}
		var addr = $("#updateAddrView").val() + " " + $("#updateAddrDetail").val();
		$("#updateAddr").val(addr);

		$("#updateForm").submit();
		alert("회원정보 수정이 완료 되었습니다!");
	});
	// 회원탈퇴
	$("#deleteBtn").on("click",function(){
		var userid = $("#userid").val();
		if(confirm("정말 탈퇴 하시겠습니까?")){
			location.href="/myshop/user/delete?userid="+userid;
			alert("회원 탈퇴가 완료되었습니다!");
		}		
	})
	
	// 카카오 주소 API 팝업
	$("#updateAddrBtn").on("click", function() {
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
								$("#updateZipcode").val(data.zonecode);
								$("#updateAddrView").val(addr);
								// 커서를 상세주소 필드로 이동한다.
								$("#updateAddrDetail").focus();
							}
						}).open();
			});

})