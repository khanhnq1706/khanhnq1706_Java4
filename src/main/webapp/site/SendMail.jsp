<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="./SendMailServelet" method="post">
<h2>Send Email</h2>
From: <input type="email" name="from"> <br>
To <input type="email" name ="to"> <br>
Subject: <input type="text" name="subject"> <br>
Body: <textarea rows="3" cols="30" name ="body"></textarea> <br> <hr>
<button type="submit">Send</button>
</form>
