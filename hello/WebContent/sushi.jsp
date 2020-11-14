<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.Map" %>
<%
Map<String,Integer>order = (Map<String,Integer>)session.getAttribute("order");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>寿司屋</title>
</head>
<body>
<h1>寿司屋</h1>
<h2>注文</h2>
<form action="/s1832074/Sushi" method="POST">
<table>
<tr>
	<th>商品</th>
	<th>単価</th>
	<th>注文数</th>
</tr>
<tr>
	<td>たまご</td>
	<td>100</td>
	<td><input type="text" name="num1" size="3" value ="0"></td>
</tr>
<tr>
	<td>中トロ</td>
	<td>200</td>
	<td><input type="text" name="num2" size="3" value ="0"></td>
</tr>
<tr>
	<td>いくら</td>
	<td>300</td>
	<td><input type="text" name="num3" size="3" value ="0"></td>
</tr>
<tr>
	<td>うに</td>
	<td>400</td>
	<td><input type="text" name="num4" size="3" value ="0"></td>
</tr>
</table>
<input type="submit" name="action" value="注文">
<input type="submit" name="action" value="リセット">
</form>
<hr>
<% if(order != null){ %>
<h2>会計</h2>
<table>
<tr><td> 商品</td> <td>注文数</td></tr>
<tr><td> たまご </td> <td> <%= order.get("たまご") %>個</td></tr>
<tr><td> 中トロ </td> <td> <%= order.get("中トロ") %>個</td></tr>
<tr><td> いくら </td> <td> <%= order.get("いくら") %>個</td></tr>
<tr><td> うに </td> <td> <%= order.get("うに") %>個</td></tr>
<tr><td> 合計金額 </td>  <td> <%= order.get("合計") %>円</td></tr>
</table>

<%} %>
</body>
</html>