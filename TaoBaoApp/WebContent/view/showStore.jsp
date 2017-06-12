<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Header.jsp" %>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    <title>浏览商品</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>

    <body>
	<jsp:useBean id="data" class="data.Data" scope="session"></jsp:useBean>

	<br />
	<br />
	<center>
		<table border="1" bordercolor="#00ff00" cellpadding="10"
			cellspacing="2" width="500" height="80">
			<caption>
				<b>店铺简略信息表</b><br>
			</caption>
			<tr>
				<th>序号</th>
				<th>店铺名称</th>
				<th>店铺销量</th>
				<th>进入店铺</th>
			</tr>

			<%
	  	       for (int i = 0,num=data.getDataStoreList().size(); i < num;)
               {
                   int sid = data.getDataStoreList().get(i).getSid();
                   String sname = data.getDataStoreList().get(i).getSname();
                   int snum = data.getDataStoreList().get(i).getSnum();

                   String detail = "<form action='/TaoBaoApp/control/HandleStoreServlet?key=2' method='post'>"+
		                       "<input type='hidden' name='id' value="+sid+">"+
		                       "<input type='submit' value='进入店铺'></form>";
          
               %>
			<tr <% if(i%2 == 0){%> bgcolor="#FFE4B5" <%}else{%> bgcolor="#FFFACD"
				<%};//隔行换颜色%>>
				<td><%= ++i %></td>
				<td><%= sname %></td>
				<td><%= snum%></td>
				<td><%= detail %></td>
			</tr>
			<%}
  	        %>

		</table>

	</center>
</body>
</html>