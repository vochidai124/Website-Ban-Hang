<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header-chitiet" class="container-fluid">
		<nav class="navbar navbar-expand-sm navbar-dark fixed-top"> <!-- Brand -->
		<a class="navbar-brand col-sm-2" href="#"><img id="icon-yame" class="float-right" src='<c:url value="/resources/image/icon-yame.jpg"/>'/></a> <!-- Links -->
		<ul class="nav navbar-nav col-sm-6 justify-content-center nav_center">
			<li class="nav-item active"><a class="nav-link" href="#">TRANG CHỦ</a></li>
			
			<!-- Dropdown -->
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown"> Dropdown </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Link 1</a> 
					<a class="dropdown-item" href="#">Link 2</a> 
					<a class="dropdown-item" href="#">Link 3</a>
				</div>
			</li>
			<li class="nav-item"><a class="nav-link" href="#">DỊCH VỤ</a></li>
			<li class="nav-item"><a class="nav-link" href="#">LIÊN HỆ</a></li>
		</ul>
		<ul class="nav navbar-nav col-sm-4 nav_left">
			<c:choose>
				<c:when test="${chucaidau!=null }">
					<li class="nav-item "><a class="nav-link dangnhapthanhcong" href="dangnhap/">${chucaidau }</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item "><a class="nav-link" href="dangnhap/">ĐĂNG NHẬP</a></li>
				</c:otherwise>
			</c:choose>
			<li> <a class="navbar-brand icon-gio-hang" href="#"><img class="float-right" src='<c:url value="/resources/image/icon_giohang.png"/>'/></a><li>
		</ul>
		</nav>
	</div>
	<!-- end sản phẩm -->
	
	<div class="container-fluid body-chitiet">
		<div class="row" style="margin-top: 16px;">
		<div class="col-sm-2 col-md-2">
				<h3>Danh Muc San Pham</h3>
				<ul class="mymenu">
				<c:forEach var="value" items="${danhmuc }">
					<li><a href="#">${value.getTendanhmuc() }</a></li>
				</c:forEach>
				</ul>
			</div>
			<div class="col-sm-8 col-md-8">
			<div class="row">
				<div class="col-sm-4 col-md-4">
					<img src='<c:url value="/resources/image/sanpham/${sanpham.getHinhsanpham() }"/>'/>
				</div>
				<div class="col-sm-8 col-md-8">
					<h3 id="tensp" data-masp="${sanpham.getMasanpham() }">${sanpham.getTensanpham() }</h3>
					<h4 id="giatien" data-value="${sanpham.getGiatien() }" style="color: red;">${sanpham.getGiatien() } VND</h4>
					<table class="table">
						<thead>
							<tr>
								<td><h5>Màu sản phẩm</h5></td>
								<td><h5>Size</h5></td>
								<td><h5>Số lượng</h5></td>
								<td><h5>Thêm vào giỏ</h5></td>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="chitietsanpham" items="${sanpham.getChitietsanpham() }">
							<tr>
								<td class="mau" data-mamau="${chitietsanpham.getMausanpham().getMamau() }">${chitietsanpham.getMausanpham().getTenmau() }</td>
								<td class="size" data-masize="${chitietsanpham.getSizesanpham().getMasize() }">${chitietsanpham.getSizesanpham().getSize() }</td>
								<td class="soluong">${chitietsanpham.getSoluong() }</td>
								<td><button class="btn-success btn-giohang">Thêm</button></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>	
			</div>
			<div class="col-sm-2 col-md-2">
				<span>
					${sanpham.getMota() }
				</span>
			</div>
		</div>
	</div>
	
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">THÔNG TIN SHOP</span></p>
				<span>Yame là một thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khác hàng</span>
			</div>
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">LIÊN HỆ</span></p>
				<span>43 Nguyễn Trãi, phường 12, quận 5, TP. Hồ Chí Minh <br/> vochidai12@gmail.com <br/> 0372429920</span>
			</div>
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">GÓP Ý</span></p>
				<form action="">
					<input class="material-textinput" style="margin-bottom: 8px;" type="text" placeholder="Email"/><br/>
					<textarea rows="4" cols="50" placeholder="Nội Dung"></textarea>
					<button class="material-primary-button">Đồng Ý</button>
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp" />
</body>
</html>