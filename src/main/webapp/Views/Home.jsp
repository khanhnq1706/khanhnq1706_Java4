<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<style type="text/css">
.web_name {
	font-family: Arial, sans-serif;
	font-size: 16px;
	font-weight: bold;
	font-style: italic;
	text-shadow: 2px 2px 5px #000000;
	text-decoration: none;
}

.cagetory>li>a {
	text-decoration: none;
	color: black;
}

body {
	background-image: url("Images/Background.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
}

.likebutton {
	background-color: #3B5998;
	border: none;
	color: white;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 12px;
}

.likebutton:hover {
	background-color: #3e8e41;
}

.likebutton:active {
	background-color: red;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}

.likebutton.pressed {
	background-color: red;
}

.sharebutton {
	background-color: #3B5998;
	border: none;
	color: white;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 12px;
}

.sharebutton:hover {
	background-color: #3e8e41;
}

.sharebutton:active {
	background-color: #3e8e41;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}
</style>
<script>
	function toggleButtonColor(btn) {
		btn.classList.toggle('pressed');
	}
	function shareContent() {
		// Add your share functionality here
		var currentUrl = window.location.href;
		FB.ui({
			method : 'share',
			href : currentUrl,
		}, function(response) {
		});
	}
</script>
</head>
<body>
	<header class="contaier-fluid">
		<div>
			<div style="position: absolute; width: 15%">
				<img style="width: 100%" ; class="ms-auto rounded-circle" alt="logo"
					src="/AssignmentJava4_Gd1/Images/Logo.jpg""> <a
					class="fs-1 web_name" href="Home.jsp" style="width: 100%">Hài
					Hước TV</a>
			</div>
			<img style="width: 100%; height: 350px" alt="background"
				src="/AssignmentJava4_Gd1/Images/Background.jpg">
		</div>
	</header>
	<main>
		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg">
			<div class="container-fluid bg-secondary py-2">
				<a class="navbar-brand" href="Home.jsp">Home</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						 
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="Contact.jsp">Liên Hệ</a></li>
						<li class="nav-item"><a class="nav-link" href="#accordionFlushExample">FAQ</a></li>
					</ul>
					<div class="position-relative d-flex">
										  <c:if test="${not empty currentUser}">
    <p class="mt-3">Welcome ${currentUser.fullname}</p>
  </c:if>
					<c:if test="${currentUser.admin}">
											<button class="btn btn-secondary "><a class="dropdown-item"
												href="/Lab5_Java4/Views/Bai3/CustomerManager.jsp">Quản trị</a></button>
										</c:if>

						<div class="btn-group">
							<button type="button" class="btn btn-secondary dropdown-toggle"
								data-bs-toggle="dropdown" aria-expanded="false">My
								Account</button>
							<ul class="dropdown-menu dropdown-menu-end">
								<c:choose>
									<c:when test="${empty currentUser}">
									
										<li><a class="dropdown-item"
											href="/Lab5_Java4/Views/Bai3/LoginAndRegister.jsp">Đăng
												nhập/Đăng kí</a></li>
									</c:when>
									<c:otherwise>

    									<li><a class="dropdown-item"
											href="/Lab5_Java4/Views/Bai3/ChangeInformation.jsp">Quản
												lý thông tin tài khoản</a></li>
										<li><a class="dropdown-item"
											href="/Lab5_Java4/Views/Bai3/ChangePassword.jsp">Đổi mật
												khẩu</a></li>
										<li><a class="dropdown-item" href="./log-out">Logout</a></li>
										<li><a
											class="dropdown-item text-decoration-none"
											href="Favorite.jsp">My Favorite</a></li>
										<!-- Thêm dòng này -->
										
									</c:otherwise>
								</c:choose>

							</ul>
						</div>

					</div>
				</div>
			</div>
		</nav>
		<div class="d-flex">
			<div class="row col-9">
				<!-- List Video -->
				<div class="row d-flex container-fluid mt-2">
					<jsp:include page="/site/Items.jsp"></jsp:include>
				</div>
				<!--  Pagination -->
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</nav>
			</div>
			<!-- List Video Cagetory -->
			<div class="col-3 mt-2 shadow-lg text-center">

				<div class="accordion rounded"
					style="width: 100%; border: 2px solid green" id="accordionExample">
					<div class="accordion-item bg-dark text-info ">
						<h2 class="accordion-header">
							<button class="accordion-button" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseOne"
								aria-expanded="true" aria-controls="collapseOne">Thể
								Loại Comedian</button>
						</h2>
						<div id="collapseOne" class="accordion-collapse collapse show"
							data-bs-parent="#accordionExample">
							<div class="accordion-body">
								<ul class="list-group cagetory"
									style="width: 100%; border: 2px solid green">

									<c:forEach var="i" begin="1" end="4">
										<li class="list-group-item" style="border: 1px solid green"><a
											href="#">Phim ${i}</a></li>
									</c:forEach>


								</ul>
							</div>
						</div>
					</div>
					<div class="accordion-item bg-dark text-info ">
						<h2 class="accordion-header">
							<button class="accordion-button collapsed" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseTwo"
								aria-expanded="false" aria-controls="collapseTwo">Thể
								Loại Hài Kịch</button>
						</h2>
						<div id="collapseTwo" class="accordion-collapse collapse"
							data-bs-parent="#accordionExample">
							<div class="accordion-body">
								<ul class="list-group cagetory"
									style="width: 100%; border: 2px solid green">
									<c:forEach var="i" begin="5" end="8">
										<li class="list-group-item" style="border: 1px solid green"><a
											href="#">Phim ${i}</a></li>
									</c:forEach>
								</ul>

							</div>
						</div>
					</div>
					<div class="accordion-item bg-dark text-info ">
						<h2 class="accordion-header">
							<button class="accordion-button collapsed" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseThree"
								aria-expanded="false" aria-controls="collapseThree">
								Thể Loại Phim Hài</button>
						</h2>
						<div id="collapseThree" class="accordion-collapse collapse"
							data-bs-parent="#accordionExample">
							<div class="accordion-body">
								<ul class="list-group cagetory"
									style="width: 100%; border: 2px solid green">
									<c:forEach var="i" begin="9" end="12">
										<li class="list-group-item" style="border: 1px solid green"><a
											href="#">Phim ${i}</a></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div>
					<ul class="list-group mt-2 "
						style="width: 100%; border: 2px solid green">
						<li class="list-group-item bg-dark text-info "
							style="border: 1px solid green">Danh sách video mới nhất</li>
						<c:forEach var="i" begin="1" end="3">
							<a href="#">
								<li class="list-group-item bg-dark text-info "
								style="border: 1px solid green">
									<div class="d-flex mb-3">
										<div class="card d-flex"
											style="width: 14rem; border: 2px solid orange;">
											<img src="Images/dog.jpg"
												class="card-img-top" alt="...">
											<div class="card-body">Phim Hài ${i }</div>
										</div>
									</div>
							</li>
							</a>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="accordion accordion-flush" id="accordionFlushExample">
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
        Câu hỏi 1:
      </button>
    </h2>
    <div id="flush-collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the first item's accordion body.</div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
        Câu hỏi 2:
      </button>
    </h2>
    <div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the second item's accordion body. Let's imagine this being filled with some actual content.</div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
        Câu hỏi 3:
      </button>
    </h2>
    <div id="flush-collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the third item's accordion body. Nothing more exciting happening here in terms of content, but just filling up the space to make it look, at least at first glance, a bit more representative of how this would look in a real-world application.</div>
    </div>
  </div>
</div>	
	</main>
	<footer style="width: 100%" class="container-fluid py-3 bg-secondary">
		<div class="text-center py-3">
			<span class="text-muted">FPT Polytechnic ©2020. All rights
				reserved.</span>
		</div>
	</footer>
</body>

</html>