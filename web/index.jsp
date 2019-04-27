<%@ page import="Entities.Student" %>
<%@ page import="static java.lang.Boolean.TRUE" %>
<%@ page import="static java.lang.Boolean.FALSE" %>
<%@ page import="Dao.JDBCConnect" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 2019/4/22
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎页面</title>
  </head>
  <body>

  <div style="background-color: cyan; width: 1260px;height: 100px;float: left">
  <%--导航栏--%>
   <jsp:include page="head.jsp"></jsp:include>
  </div>

  <div style="background-color: bisque; width: 1260px;height: 500px;float: left">
    <%
      try {
      if(request.getParameter("param").equals("insert")){
    %>
    <jsp:include page="insert.jsp"></jsp:include>
    <%}
      if(request.getParameter("param").equals("update")){
    %>
    <jsp:include page="update.jsp"></jsp:include>
    <%}
      if(request.getParameter("param").equals("select")){
    %>
    <jsp:include page="selectOne.jsp"></jsp:include>
    <%}if(request.getParameter("param").equals("delete")){
    %>
    <jsp:include page="delete.jsp"></jsp:include>
    <%
    }
      }catch (Exception e){
        %><jsp:include page="searchAll.jsp"></jsp:include><%
    }finally {

    %>
  </div>

      <div>
      <jsp:include page="foot.jsp"></jsp:include>
      </div>
    <%
    }%>
  </body>
</html>
