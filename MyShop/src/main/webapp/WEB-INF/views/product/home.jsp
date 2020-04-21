<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>My Shop</title>
</head>

<body>
<jsp:include page="../includes/header.jsp"/>
  <!-- Page Content -->
  <div class="container my-5">
    <div class="row">
      <div class="col-lg-3">
        <h1 class="my-4">My Shop</h1>
        <div class="list-group">
        <c:forEach items="${categorys }" var="categorys">
        	<a href="#" class="list-group-item">${categorys } </a>
        </c:forEach>
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
        <div class="row">
        <c:forEach items="${products }" var="products">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="${products.src }" width="100px"></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">${products.name }</a>
                </h4>
                <h5>
	                <i class="fas fa-dollar-sign"></i>
	                ${products.price }원
                </h5>
                <p class="card-text">재고 : ${products.stock }개</p>
              </div>
            </div>
          </div>
        </c:forEach>
        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->
    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  <jsp:include page="../includes/footer.jsp"></jsp:include>


</body>

</html>