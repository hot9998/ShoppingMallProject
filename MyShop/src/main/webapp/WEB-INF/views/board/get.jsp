<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>글쓰기</title>
</head>

<body>
<jsp:include page="../includes/header.jsp"/>
  <!-- Page Content -->
	<div class="container my-5" style="min-height: 1000px">
		<div class="row justify-content-center">
			<div class="col-lg-9 my-5">			
					<input type="hidden" name="type" value="${board.btype }">
					<input type="hidden" name="bnum " value="${board.bnum }"> 
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
					<div class="form-group">
						<label class="small mb-1" for="itle">제목</label> <input class="form-control py-4" name="title" id="title" type="text" value="${board.title }" readonly="readonly" /> 
					</div>
					<div class="form-group">
						<label class="small mb-1" for="userid">작성자</label> <input
							class="form-control py-4" name="writer" id="writer" type="text" value='${board.userid }' readonly="readonly" />
					</div>
					<div class="form-group">
						<label class="small mb-1" for="regdate">작성일</label> <input
							class="form-control py-4" name="regdate" id="regdate" type="text" value='<fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/>' readonly="readonly" />
					</div>
					<div class="form-group">
						<label class="small mb-1" for="content">내용</label>
						<textarea class="form-control" rows="5" name="content" id="content" readonly="readonly">${board.content }</textarea>
					</div>
					<div class="form-group mt-4 mb-0">
						<div class="form-row justify-content-center">
						<sec:authentication property="principal" var="pinfo"/>
						<sec:authorize access="hasRole('ROLE_USER')">
						<c:if test="${pinfo.username eq board.userid }">						
							<div class="col-md-2">
								<a href="/myshop/board/update?bnum=${board.bnum }" class="btn btn-outline-primary btn-block">수정하기</a>
							</div>
						</c:if>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<c:if test="${board.btype eq 1 }">
							<div class="col-md-2">
								<a href="/myshop/board/update?bnum=${board.bnum }" class="btn btn-outline-primary btn-block">수정하기</a>
							</div>
						</c:if>
						<c:if test="${board.btype eq 2 || board.btype eq 3 }">
							<div class="col-md-2">
								<a href="/myshop/board/delete?bnum=${board.bnum }&type=${board.btype}" class="btn btn-outline-danger btn-block" id="btnDelete">삭제하기</a>
							</div>
						</c:if>
						</sec:authorize>
							<div class="col-md-2">
								<a class="btn btn-outline-secondary btn-block" href="/myshop/board/list?btype=${board.btype }">리스트</a>
							</div>
						</div>
					</div>
			</div>
		</div>

	</div>
	<!-- /.container -->
  <jsp:include page="../includes/footer.jsp"></jsp:include>

</body>

</html>
