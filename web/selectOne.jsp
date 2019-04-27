<%@ page import="java.security.KeyStore" %><%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 2019/4/23
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div>
        <table>
            <tr>
                <td>学生学号</td>
                <td><input type="text" value="<%%>" id="id" name="id"> </td>
            </tr>
            <tr>
                <td>学生姓名</td>
                <td><input type="text" value="<%%>"  id="name" name="name"> </td>
            </tr>
            <tr>
                <td>学生生日</td>
                <td><input type="text"  value="<%%>"  id="birDate" name="birDate"> </td>
            </tr>
            <tr>
                <td>学生性别</td>
                <td>
                    <%
                       if((boolean)request.getAttribute("gander")){
                            out.print("女");
                       }else{
                        out.print("男");
                    }
                    %>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input value="返回" type="button" class="button">
                </td>
            </tr>
        </table>
    </div>
