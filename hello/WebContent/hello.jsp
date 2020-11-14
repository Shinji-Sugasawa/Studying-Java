<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
    <%@ page import= "java.text.SimpleDateFormat" %>
    <%
    //日時をtodayにいれる
    Date date = new Date(); //dateは現在の日時
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String today = sdf.format(date);//現在の日時を"2020/06/17"のフォーマットのStringにする

    //1~100の乱数に入れる
    int num = (int)(Math.random()*100)+1;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--JSPのコメント --%>
<p>現在の日時 <%= today %></p>
<p>乱数 <%= num %></p>
<%//課題２%>
    <%= 1+3 %>
    <%= today.length()  %><br>
<!-- HTMLのコメント -->
こんばんは！

<% //課題３ %>
<%-- 変数 --%>
<%int x = 10, y = 20;
%>
<%-- for文 --%>
<p>
<% for(int i= 1; i<=5; i++){ %>
	iの値<%= i %><br>
	<%} %>
<% int z = x+y; %>
zの値 <%= z %>
</p>

<%//課題４(1) %>
<p>
1以上100以下の3の倍数<br>
<% for(int i = 1;i<=100;i++){ %>
	<% if(i%3==0){ %>
	<%= i %>
	<% } %>
<% } %>
</p>

<%//課題4（2）%>
<p>
九九の表<br>
<table bolder ="9">
<% for(int i = 1;i<10;i++){ %>
	<tr>
	<% for(int j = 1; j<10;j++){%>
		<td><%=i*j%><td>
	<% } %><tr>
<% } %>
</table>
</p>

<%//課題4（3） %>
<p>
フィボナッチ数列の第20項まで計算<br>
<%int i = 1,j = 1; %>

<%= i %><br>
<%= j %><br>
<%for(int k = 3;k<=20;k++){%>
	 <% z = i + j;%>
	<%= z %><br>
	 <% i = j;%>
	 <% j = z;%>
 <% } %>
</p>


</body>
</html>