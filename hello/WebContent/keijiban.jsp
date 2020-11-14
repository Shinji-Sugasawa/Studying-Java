<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.Map" %>
<%
Map<String,String>order = (Map<String,String>)session.getAttribute("order");
%>
<%
Map<String,Integer>count = (Map<String,Integer>)session.getAttribute("count");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
</head>
<body>
<h1>孤独の掲示板</h1>

<form action="/s1832074/Keijiban" method="POST">

<div><input type="text" name="murmur" value = " ">
<input type="submit" name="action" value="送信">
<input type="submit" name="action" value="リセット">
</div>
</form>
機能追加:
リセットボタンを押すことで、書き込みがすべてリセットされる。
<%if(order != null){%>
<table>
<% for(int i=0;i< count.get("大きさ");i++){ %>
<tr><td><%= order.get("投稿"+i) %></td></tr>
<%} %>
</table>
<%} %>
</body>
</html>