<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
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
                    <th scope="col">FullName</th>
                    <th scope="col">Location</th>
                  </tr>
                <c:forEach var="item" items="${hhh}">
                    <tr>
                      <td>${item.username}</td>
                      <td>${item.email}</td>
                      <td>${item.fullname}</td>
                      <td>${item.location}</td>
                    </tr>
                    </c:forEach>
            </table>