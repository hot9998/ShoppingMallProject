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
<link rel="stylesheet" href="/myshop/resources/css/shop-homepage.css">
</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/productsidebar.jsp"/>
      <div class="col-lg-9">
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="/myshop/resources/img/1.jpg" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="/myshop/resources/img/2.jpg" alt="Second slide">
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
              <a href="/myshop/product/get?id=${products.id }"><img class="card-img-top" src="${products.src }" width="100px"></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="/myshop/product/get?id=${products.id }">${products.name }</a>
                </h4>
                <h5>
	                ${products.price }
	                <i class="fas fa-won-sign"></i>
                </h5>
                <c:if test="${products.stock <= 0 }">
                <p class="card-text text-danger">
                	품절
                </p>
                </c:if>
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
