<%@ page import="Dao.JDBCConnect" %>
<%@ page import="java.util.List" %>
<%@ page import="Entities.Student" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 2019/4/22
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="tableDe">
    <tr>
        <td>所有学生:</td>
        <td></td>
    </tr>

    <tr>
        <td>学生id</td>
        <td>学生姓名</td>
        <td>学生生日</td>
        <td>学生性别</td>
    </tr>

    <%
        try {
            JDBCConnect jdbcConnect = new JDBCConnect();
            ArrayList<Student> list = jdbcConnect.searchAllList();
            for (Student s: list) {
    %>

    <tr>
        <td>
            <% out.println(s.getId()); %>
        </td>

        <td>
            <a href="index.jsp?param=select"><% out.println(s.getName());%></a>
        </td>
        <td>
            <% out.println(s.getBirDate());%>
        </td>
        <td>
            <% out.println(s.isGender());  %>
        </td>
        <td>
            <a href="index.jsp?param=update&&id=<%=s.getId()%>">编辑</a>
        </td>
        <td>
            <a href="index.jsp?param=delete&&id=<%=s.getId()%>">删除</a>
        </td>
        <%
             }
        }catch (Exception e){
            out.print(e.getMessage());
        }
        %>
    </tr>
</table>