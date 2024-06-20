      <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:forEach var="item" begin="1" end="6" items="${videos}">
<div class="card bg-dark text-info text-center col-4 gap-2 items rounded  mb-3" style="width: 22rem; margin-left: 3px">
<div class="card-header">
 ${item.title}
</div>
  <div class="card-body justify-content-center ms-2">
  <a class="" href="WatchVideoServlet?watchvideoid=${item.id}">
  <img style="width: 80%;" src="/AssignmentJava4_Gd1/Images/${item.poster}" class="card-img-top" alt="...">
  </a>
  </div>
  <hr>
  <div class="card-footer">
  Thời lượng: ${item.duration} phút <br>
  Thể loại:  ${item.category} <br> 
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
  Ngày: ${item.dateup}
  </div>
</div>
</c:forEach>
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