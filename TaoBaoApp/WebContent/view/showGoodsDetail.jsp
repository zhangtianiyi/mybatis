<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>show goods detail</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
       <center><br><br>
         <table border="1" bordercolor="#4EEE94" cellpadding="10" cellspacing="0" width="400" height="80">
             <tr bgcolor=#458B74>
                <th>编号</th>
                <th>名称</th>
                <th>产地</th>
                <th>价格</th>
                <th>库存</th>
                <th>店铺</th>
                <th>销量</th>
                <th>添加到购物车</th>
            </tr>
            
            <%
            String detail = request.getParameter("detail");
            String shopCarButton = "<form action='/TaoBaoApp/control/HandleCarServlet?key=2' method='post'>"+
                                   "<input type='hidden' name='Car' value="+detail+">"+
                                   "<input type='submit' value='加入购物车'></form>";
            String[] details = detail.split(",");
            %><tr bgcolor=#43CD80><%
	            for(int i=0 ;i<7; i++)
	            {%>
		               <td><%= details[i]%></td>
	            <%}%>
	                   <td><%= shopCarButton%></td>
             </tr>
         </table>
         <br>
        </center>
  </body>
</html>
