<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
				
<div class="col-9 mb-3">
<h2>${video.title}</h2>
  <p>Nội dung phim: ${video.description}</p>
  <div class="embed-responsive " style="max-width:100%; height:100%; margin-right: 10px">
  <iframe class="me-1 ms-2"  width="100%" height="90%"  src="https://www.youtube.com/embed/${video.id}" title="${video.title}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

</div>
  
