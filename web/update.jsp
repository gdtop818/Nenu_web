<%@ page import="Entities.Student" %>
<%@ page import="Dao.JDBCConnect" %><%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 2019/4/22
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>

    <%
       Integer id=Integer.parseInt(request.getParameter("id"));
       try {
           JDBCConnect jdbcConn = new JDBCConnect();
           Student student = new Student();
           student=jdbcConn.searchOne(Integer.parseInt(request.getParameter("id")));
    %>

    <form action="update?id=<%=request.getParameter("id")%>" method="post">
        <table>
            <tr>
                <td>学生学号</td>
                <td><%=request.getParameter("id")%>(学号无法更改)</td>
            </tr>
            <tr>
                <td>学生姓名</td>
                <td><input type="text" placeholder="<%=student.getName()%>"  id="name" name="name"> </td>
            </tr>
            <tr>
                <td>学生生日</td>
                <td><input type="text" placeholder="<%=student.getBirDate()%>" id="birDate" name="birDate"> </td>
            </tr>
            <tr>
                <td>学生性别</td>
                <td>
                    <%
                            if(student.isGender()){
                                  out.print("女");
                            }else{
                                  out.print("男");
                            }
                        }catch (Exception e ){
                                out.print(e.getMessage());
                        }
                    %>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input value="确认提交" type="submit" class="button">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
