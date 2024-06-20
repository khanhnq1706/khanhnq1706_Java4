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
<body >

	<div class="container">
		<div
			class="row d-flex border border-warning shadow-lg p-4 mb-4 rounded"
			style="margin-top: 10%; margin-left: 35%; width: 30%; background-color: #d08cfe">
			<div class="col-sm justify-content-center text-center" >
				<h2 class="text-danger">Edit profile</h2>
					<form action="./ChangeInformationServlet" method="post" style="width: 100%">
						<div class="card card-body py-3 mb-3">
							<input class="mb-3" placeholder="Email" name="email">
							<input class="mb-3" placeholder="Fullname"name="fullname"> 
								<input class="mb-3" placeholder="Password" name="password">
								<input class="mb-3" placeholder="Location" name="location">
							</div>
						<div class="text-center">
							<button class="btn btn-danger" type="submit">Update</button>
						</div>

					</form>
			</div>
		</div>
	</div>

</body>
</html>