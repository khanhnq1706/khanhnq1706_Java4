
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<nav>
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
          <button class="nav-link active" id="nav-videoediting-tab" data-toggle="tab" data-target="#nav-videoediting" type="button" role="tab" aria-controls="nav-videoediting" aria-selected="true">Video Editing</button>
          <button class="nav-link" id="nav-listvideo-tab" data-toggle="tab" data-target="#nav-listvideo" type="button" role="tab" aria-controls="nav-listvideo-tab" aria-selected="false">List Video</button>

        </div>
      </nav>
      <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-videoediting" role="tabpanel" aria-labelledby="nav-videoediting-tab">
            <form action="/AssignmentJava4_Gd1/VideoManagerServlet" method="post" enctype="multipart/form-data">
                <div class="card"> 
                    <div class="card-body">
                       <div class="row">
                        <div class="col-3">
                            <div class="border p-3">
                                <img src="/AssignmentJava4_Gd1/Images/${managervideos.poster}" alt="" class="img-fluid" height="100px" width="100px">
                                    Video Poster:
                                  
                                    <input name="poster" type="file"> <br>
                            </div>
                        </div>
                        <div class="col-9">
                            <div class="form-group">
                              <label for="youtubeid">Youtube ID</label>
                              <input type="text" class="form-control" value="${managervideos.id}" name="id"  aria-describedby="youtubeidHid" >
                              <small id="youtubeidHid" class="form-text text-muted">Youtube id is required</small>
                            </div>
                            <div class="form-group">
                              <label for="videotitle">Video Title</label>
                              <input type="text" class="form-control" value="${managervideos.title}" name="title"  aria-describedby="videoTitle" placeholder="video title">
                              <small id="videoTitle" class="form-text text-muted">Video title is required</small>
                            </div>
                            <div class="form-group">
                              <label for="viewcount">View Count</label>
                              <input type="number" class="form-control" value="${managervideos.views}" name="views" id="viewcount" aria-describedby="viewCountHid" placeholder="View Count">
                              <small id="viewCountHid" class="form-text text-muted">View count is required</small>
                            </div>
                            <div class="form-group">
                                <label for="duration">Video Duration</label>
                                <input type="number" class="form-control" value="${managervideos.duration}" name="duration" id="duration" aria-describedby="durationHid" placeholder="Duration">
                                <small id="durationHid" class="form-text text-muted">View duration is required</small>
                              </div>
                              <div class="form-group">
                                <label for="category">Video Category</label>
                                <input type="text" class="form-control" value="${managervideos.category}" name="category" id="category" aria-describedby="categoryHid" placeholder="Category">
                                <small id="categoryHid" class="form-text text-muted">View category is required</small>
                              </div>
                               <div class="form-group">
                                <label for="dateup">Video Dateup</label>
                                <input type="date" class="form-control" value="${managervideos.dateup}" name="dateup" id="dateup" aria-describedby="dateUpHid" >
                                <small id="dateUpHid" class="form-text text-muted">View dateup is required</small>
                              </div>
                            <div class="form-check form-check-inline">
                                <label><input type="radio" class="form-check-input" value="true" name="active"  ${managervideos.active ? "checked" : ""} >Active</label>
                                <label><input type="radio" class="form-check-input" value="false" name="active"  ${managervideos.active ? "" : "checked"}>Inactive</label>
                            </div>
                        </div>
                       </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="description">Description</label>
                            <textarea  name="description" id="description" cols="30" rows="4" class="form-control">${managervideos.description}</textarea>
                        </div>
                    </div>
                    <div class="card-footer text-muted">
                       <button formaction="/AssignmentJava4_Gd1/createvideo" class="btn btn-primary">Create</button>
                       <button formaction="/AssignmentJava4_Gd1/updatevideo" class="btn btn-primary">Update</button>
                       <button formaction="/AssignmentJava4_Gd1/deletevideo" class="btn btn-primary">Delete</button>
                       <button formaction="" class="btn btn-primary">Reset</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="tab-pane fade" id="nav-listvideo" role="tabpanel" aria-labelledby="nav-listvideo-tab">

            <table class="table table-strip">
                <tr>
                    <td>Youtube ID</td>
                    <td>Title</td>
                    <td>Poster</td>
                    <td>Description</td>
                    <td>Active</td>
                    <td>Views</td>
                    <td>Duration</td>
                    <td>Category</td>
                    <td>Date up</td>
                    <td>&nbsp;</td>
                </tr>
                <c:forEach var="item" items="${listvideo}">
                    <tr>
                    <td>${item.id}</td>
                    <td>${item.title}</td>
                    <td>${item.poster}</td>
                    <td>${item.description}</td>
                    <td>${item.active}</td>
                    <td>${item.views}</td>
                    <td>${item.duration}</td>
                    <td>${item.category}</td>
                    <td>${item.dateup}</td>
                    <td>
                      
                        <a href="/AssignmentJava4_Gd1/readvideo?videoid=${item.id}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325"/>
                          </svg></a>
                    </td>
                    
                    </tr>
                </c:forEach>
            </table>
        </div>
      
      </div>
