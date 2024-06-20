<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<nav>
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
          <button class="nav-link active" id="nav-videoediting-tab" data-toggle="tab" data-target="#nav-videoediting" type="button" role="tab" aria-controls="nav-videoediting" aria-selected="true">User Editing</button>
          <button class="nav-link" id="nav-listvideo-tab" data-toggle="tab" data-target="#nav-listvideo" type="button" role="tab" aria-controls="nav-listvideo-tab" aria-selected="false">List User</button>
        </div>
      </nav>
      <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-videoediting" role="tabpanel" aria-labelledby="nav-videoediting-tab">
            <form action="./UserManagerServlet" method="post">
                <div class="card">
                    
                    <div class="card-body">
                       <div class="row">
                        <div class="col-3">
                        </div>
                        <div class="col-9">
                            <div class="form-group">
                              <label for="username">Username</label>
                              <input type="text" class="form-control" value="${userediting.username}" name="username" id="username" aria-describedby="usernameHid" placeholder="">
                              <small id="usernameHid" class="form-text text-muted">Username is required</small>
                            </div>
                            <div class="form-group">
                              <label for="password">Password</label>
                              <input type="text" class="form-control" value="${userediting.password}" name="password" id="password" aria-describedby="password" placeholder="video title">
                              <small id="password" class="form-text text-muted">Password is required</small>
                            </div>
                            <div class="form-group">
                              <label for="fullname">Fullname</label>
                              <input type="text" class="form-control" value="${userediting.fullname}" name="fullname" id="fullname" aria-describedby="fullnameHid" placeholder="Count">
                              <small id="fullnameHid" class="form-text text-muted">Fullname is required</small>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" value="${userediting.email}" name="email" id="email" aria-describedby="emailHid" placeholder="email">
                                <small id="emailHid" class="form-text text-muted">Email is required</small>
                              </div>
                              <div class="form-group">
                                <label for="location">Location</label>
                                <input type="text" class="form-control" value="${userediting.location}" name="location" id="location" aria-describedby="locationHid" placeholder="location">
                                <small id="locationHid" class="form-text text-muted">Location is required</small>
                              </div>
                              
                            <div class="form-check form-check-inline">
                                <label><input type="radio" class="form-check-input" value="true" name="admin" id="status" ${userediting.admin ? "checked" : ""} >Admin</label>
                                <label><input type="radio" class="form-check-input" value="false" name="admin" id="status" ${userediting.admin ? "" : "checked"}>User</label>
                            </div>
                        </div>
                       </div>
                    </div>
                    <div class="card-footer text-muted">
                       <button formaction="/AssignmentJava4_Gd1/createuser" class="btn btn-primary">Create</button>
                       <button formaction="/AssignmentJava4_Gd1/updateuser" class="btn btn-primary">Update</button>
                       <button formaction="/AssignmentJava4_Gd1/deleteuser" class="btn btn-primary">Delete</button>
                       <button formaction="/AssignmentJava4_Gd1/resetuser" class="btn btn-primary">Reset</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="tab-pane fade" id="nav-listvideo" role="tabpanel" aria-labelledby="nav-listvideo-tab">

            <table class="table table-strip">
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>FullName</th>
                    <th>Email</th>
                    <th>Location</th>
                    <th>Admin</th>
                    <td>&nbsp;</td>
                </tr>
               <c:forEach var="item" items="${listuser}">
                    <tr>
                    <td>${item.username}</td>
                    <td>${item.password}</td>
                    <td>${item.fullname}</td>
                    <td>${item.email}</td>
                    <td>${item.location}</td>
                    <td>${item.admin?"yes":"no"}</td>                   
                    <td>

                        <a href="/AssignmentJava4_Gd1/readuser?id=${item.username}" ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325"/>
                          </svg></a>
                    </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
      
      </div>
      <script>
      $(document).ready(function(){
    	  $(".my-link").click(function(e){
    	    e.preventDefault(); // ngăn chặn hành vi mặc định của thẻ a
    	    var href = $(this).attr('href'); // lấy giá trị của thuộc tính href
    	    var id = href.substring(1); // loại bỏ ký tự '#' đầu tiên để lấy id
    	    var servlet = $(this).data('servlet'); // lấy đường dẫn servlet từ thuộc tính data

    	    // chuyển đến id
    	    $('html, body').animate({
    	      scrollTop: $(href).offset().top
    	    }, 'slow');

    	    // gọi đến servlet
    	    $.get(servlet, function(data, status){
    	      // xử lý phản hồi ở đây
    	    });
    	  });
    	});

        </script>
