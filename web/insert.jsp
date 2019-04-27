<%@ page import="Entities.Student" %>
<%@ page import="java.security.KeyStore" %>
<%@ page import="static java.lang.Boolean.TRUE" %>
<%@ page import="static java.lang.Boolean.FALSE" %>
<%@ page import="Dao.JDBCConnect" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 2019/4/22
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
   <div>
       <form action="insert" method="post">
           <table>
               <tr>
                   <td>学生学号</td>
                   <td><input type="text"  id="id" name="id"> </td>
               </tr>
               <tr>
                   <td>学生姓名</td>
                   <td><input type="text" id="name" name="name"> </td>
               </tr>
               <tr>
                   <td>学生生日</td>
                   <td><input type="text" id="birDate" name="birDate"> </td>
               </tr>
               <tr>
                   <td>学生性别</td>
                   <td>
                       女<input type="radio" name="gander" value="TRUE">
                       男<input type="radio" name="gander" value="FALSE">
                   </td>
               </tr>
               <tr>
                   <td></td>
                   <td>
                       <input value="确认提交" type="submit">
                   </td>
               </tr>
           </table>
       </form>
   </div>

</body>
</html>
