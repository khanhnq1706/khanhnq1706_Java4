<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url("/AssignmentJava4_Gd1/Images/BackgroundLogin.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
}
</style>
</head>
<body>


<!-- dsgsd -->
<div class="container-fluid">
	
		<div
			class="row d-flex border border-warning shadow-lg p-4 mb-3 rounded"
			style="margin-top: 10%; margin-left: 15%; width: 70%; background-color: #e3ccd1">
			<div class="col=6 col-sm rounded" style="background-color: #d08cfe">
				<form action="/AssignmentJava4_Gd1/LoginAndRegister" method="post">
					
					<div class="mb-3 mt-3">
					
						<label  class="form-label">Ussername:</label> 
						<h6 >${message}</h6>
						<input
							type="text" class="form-control" id="username"
							placeholder="Enter username" name="username">
					</div>
					<div class="mb-3">
						<label  class="form-label">Password:</label> <input
							type="password" class="form-control" id="pwd"
							placeholder="Enter password" name="password">
					</div>
					<div class="form-check mb-3">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox" name="remember">
							Remember me
						</label> <a class="text-decoration-none text-danger" href="#"
							data-bs-toggle="modal" data-bs-target="#exampleModal"> Forgot
							Password?</a>
						<button formaction="/AssignmentJava4_Gd1/Login" class="btn btn-danger mb-3">Login</button>
						
						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Forgot Password</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div>
        <div class="form-group">
        <small id="Message">${forgotpassnotifice}</small>
</div>
<div class="form-group">
    <label for="username">
        Email
    </label>
    <input placeholder="Username" type="text" class="form-control" id="" name="email" aria-describedby="Email">
    <small id="Email" class="form-text text-mute"></small>
</div>
        <button class="btn btn-succses btn-primary" type="submit" formaction="/AssignmentJava4_Gd1/SendEmailServlet">Send</button>
    
        </div>
        <label> <input name="verifycode" placeholder="Mã xác nhận"> </label>
        <input name="verificationCode" hidden="">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button formaction="/AssignmentJava4_Gd1/ForgotPasswordServlet" type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>
  </div>
						<!--  -->
					</div>
						<!-- Sign In -->
					</div>
				</form>
			</div>
			<div class="col-6 col-sm justify-content-center text-center rounded"
				style="background-color: #c2ccff">
				<h2 class="text-danger">Welcome, Friend!</h2>
				<p>Enter Your Pesonal Details And Enjoy Your Time!</p>
				<button class="btn btn-primary mb-3" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapseExample"
					aria-expanded="false" aria-controls="collapseExample">
					Sign in</button>
				<div class="collapse" id="collapseExample">
					<form action="AssignmentJava4_Gd1/RegistrationSevlet" method="post">
					<h6 >${singupmessage}</h6>
						<div class="card card-body py-3 mb-3">
						<input  type="text" class="mb-3" placeholder="Username" name="username">
							<input type="password" class="mb-3" placeholder="Password" name="password">
							<input type="text" class="mb-3" placeholder="Fullname"
								name="fullname"> 
								<input type="email" class="mb-3" placeholder="Email" name="email">
								<input type="text" class="mb-3" placeholder="Location" name="location">
								<input type="hidden" name="admin" value="false">
						<div class="text-center">
							<button formaction="/AssignmentJava4_Gd1/RegistrationSevlet" class="btn btn-danger" type="submit">Sign in</button>
						</div>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript">
	document.getElementById("email").addEventListener("submit", function(event){
		  event.preventDefault(); // Ngăn chặn hành vi mặc định của form

		  var email = document.getElementById("email").value; // Lấy giá trị email từ form

		  // Tạo một đối tượng XMLHttpRequest
		  var xhttp = new XMLHttpRequest();

		  // Thiết lập hàm xử lý khi nhận được phản hồi từ máy chủ
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      // In ra thông báo khi nhận được phản hồi
		      console.log("Email đã được gửi!");
		      // Hiển thị thông báo cho người dùng
		      document.getElementById("Message").textContent = "Email đã được gửi!";
		    }
		  };

		  // Mở yêu cầu
		  xhttp.open("POST", "/AssignmentJava4_Gd1/ForgotPasswordServlet", true);

		  // Gửi yêu cầu cùng với email
		  xhttp.send("email=" + email);
		});

	</script>
</body>
</html>