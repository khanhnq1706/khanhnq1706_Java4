<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.items{

  background-repeat: no-repeat;
  background-position: center;
}
.likebutton{
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
.likebutton:hover{
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
</style>
<script>
function toggleButtonColor(btn) {
  btn.classList.toggle('pressed');
}
function shareContent() {
	  // Get the current URL
	  var currentUrl = window.location.href;

	  // Share the current URL on Facebook
	  FB.ui({
	    method: 'share',
	    href: currentUrl,
	  }, function(response){});
	}
</script>
</head>
<body>
<c:forEach var="items" begin="1" end="8">
<div class="card bg-dark text-info text-center d-flex col-3 me-5 ms-5 items rounded  ">
<div class="card-header">
Video Hài ${items}
</div>
  <div class="card-body justify-content-center ms-2">
  <a class="" href="WatchVideo.jsp">
  <img style="width: 80%;" src="/AssignmentJava4_Gd1/Images/dog.jpg" class="card-img-top" alt="...">
  </a>
  </div>
  <hr>
  <div class="card-footer">
  Thời lượng: 176 phút <br>
  Thể loại:  Comedian <br> 
<div class="d-flex justify-content-center">
<button class=" btn likebutton active" onclick="toggleButtonColor(this)">

 <svg xmlns="http://www.w3.org/2000/svg"  width="16" height="16" fill="currentColor" class="bi bi-hand-thumbs-up-fill" viewBox="0 0 16 16">
  <path d="M6.956 1.745C7.021.81 7.908.087 8.864.325l.261.066c.463.116.874.456 1.012.965.22.816.533 2.511.062 4.51a10 10 0 0 1 .443-.051c.713-.065 1.669-.072 2.516.21.518.173.994.681 1.2 1.273.184.532.16 1.162-.234 1.733q.086.18.138.363c.077.27.113.567.113.856s-.036.586-.113.856c-.039.135-.09.273-.16.404.169.387.107.819-.003 1.148a3.2 3.2 0 0 1-.488.901c.054.152.076.312.076.465 0 .305-.089.625-.253.912C13.1 15.522 12.437 16 11.5 16H8c-.605 0-1.07-.081-1.466-.218a4.8 4.8 0 0 1-.97-.484l-.048-.03c-.504-.307-.999-.609-2.068-.722C2.682 14.464 2 13.846 2 13V9c0-.85.685-1.432 1.357-1.615.849-.232 1.574-.787 2.132-1.41.56-.627.914-1.28 1.039-1.639.199-.575.356-1.539.428-2.59z"/>
</svg>
</button>
 <div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v10.0" nonce="Iwz9c1wZ"></script>

<button class="btn sharebutton" onclick="shareContent()">
	Share
</button>
</div>
 <br><hr>
  Ngày: 22-12-2023
  </div>
</div>

</c:forEach>
</body>

</html>