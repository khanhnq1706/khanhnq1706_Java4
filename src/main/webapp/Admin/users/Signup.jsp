<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
   <%@ page isELIgnored="false" %>
 <div class="col mt-4">
     <form action="./Home" method="post">
<input name ="id" value="${user.id}" placeholder="Username"><br>
<input name ="password" value="${user.password}" placeholder="Password"> <br>
<input name ="email" value="${user.email}" placeholder="Email Address"> <br>
<input name ="fullname" value="${user.fullname}" placeholder="Fullname"><br>
<input name="admin" type="radio"  value="true" ${user.admin ? "checked" : ""}> Admin
<input name ="admin" value="false" type="radio" ${user.admin ? "" : "checked"}> User <br>
<hr>
<button formaction="./create" type="submit">Create</button>
<button formaction="./update"" type="submit">Update</button>
<button formaction="./delete"" type="submit">Delete</button>
<table>
<tr>
<th>Username</th>
<th>Password</th>
<th>FullName</th>
<th>Email</th>
<th>Admin</th>
</tr>
<c:forEach var="item" items="${users}">
<tr>
<td>${item.id}</td>
<td>${item.password}</td>
<td>${item.fullname}</td>
<td>${item.email}</td>
<td>${item.admin?"yes":"no"}</td>
<td class="table-action">
<a href="./read/id=${item.id}">Edit</a>
</td>
</tr>
</c:forEach>
</table>
</form>	   
    </div>
