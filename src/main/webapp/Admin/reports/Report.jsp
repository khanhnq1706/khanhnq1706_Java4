
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<nav>
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
          <button class="nav-link active" id="nav-favorite-tab" data-toggle="tab" data-target="#nav-favorite" type="button" role="tab" aria-controls="nav-favorite" aria-selected="true">Favorite</button>
          <button class="nav-link" id="nav-favoriteUser-tab" data-toggle="tab" data-target="#nav-favoriteUser" type="button" role="tab" aria-controls="nav-favoriteUser-tab" aria-selected="false">Favorite User</button>
          <button class="nav-link" id="nav-shareFriend-tab" data-toggle="tab" data-target="#nav-shareFriend" type="button" role="tab" aria-controls="nav-shareFriend-tab" aria-selected="false">Share Friend</button>
        </div>
      </nav>
      <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-favorite" role="tabpanel" aria-labelledby="nav-favorite-tab">
            <table class="table table-strip table-bordered mt-3">
                <tr>
                    
                    <td>Title</td>
                    <td>Views</td>
                    <td>Dateup</td>
                    <td>Category</td>
                    
                </tr>
                <c:forEach var="item" items="${reports}">
                    <tr>
                      
                      <td>${item.title}</td>
                      <td>${item.views}</td>
                      <td>${item.dateup}</td>
                      <td>${item.category}</td>
                    </tr>
                    </c:forEach>
            </table> 
        </div>
        <div class="tab-pane fade" id="nav-favoriteUser" role="tabpanel" aria-labelledby="nav-favoriteUser-tab">
            <form action="/AssignmentJava4_Gd1/FindFavoriteByTitle" method="post"
			class="d-flex mt-4 me-1 role="search">
			<label for="videoTitle" class="col-sm-1 col-form-lable me-1">Video Title</label> <input class="form-control col-sm-1" type="text" placeholder="ID"
				name="title" >
			<button class="btn btn-outline-success" type="submit">Report</button>
		    </form>
		    <div class="card" style="width: 100%;">
			
		</div>
            <table class="table table-strip table-bordered mt-3">
                <tr>
                    <th scope="col">Username</th>
                    <th scope="col">Email</th>
                    <th scope="col">Video ID</th>
                    <th scope="col">Share Date</th>
                  </tr>
                <c:forEach var="item" items="${user.favorites}">
                    <tr>
                    <td>${item.username}</td>
                      <td>${item.email}</td>
                      <td>${item.fullname}</td>
                      <td>${item.location}</td>
                    </tr>
                    </c:forEach>
            </table>
        </div>
        <div class="tab-pane fade" id="nav-shareFriend" role="tabpanel" aria-labelledby="nav-shareFriend-tab">
            <form action="/Lab6_Java4/FindFavoriteVideosController" method="post"
			class="d-flex mt-4" role="search">
			<label for="videoTitle" class="col-sm-1 col-form-lable me-3">Video Title</label>
             <input class="form-control col-sm-1" type="text" placeholder="ID"
				name="id" value="videoTitle1">
			<button class="btn btn-outline-success" type="submit">Report</button>
		    </form>
		    <div class="card" style="width: 100%;">
			
		</div>
            <table class="table table-strip table-bordered mt-3">
                <tr>
                    <th scope="col">Sender Name</th>
                    <th scope="col">Sender Email</th>
                    <th scope="col">Receiver Email</th>
                    <th scope="col">Sent Date</th>
                  </tr>
                <c:forEach var="item" items="${shares}">
                    <tr>
                      <td>${item.shareid}</td>
                      <td>${item.username}</td>
                      <td>${item.videoid}</td>
                      <td>${item.sharedate}</td>
                    </tr>
                    </c:forEach>
            </table>
        </div>
      </div>
