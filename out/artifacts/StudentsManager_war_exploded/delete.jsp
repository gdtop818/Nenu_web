<%@ page import="Dao.JDBCConnect" %><%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 2019/4/22
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="javascript">
    function gou(secs,surl){   
    if(--secs>0){   
         settimeout("gou("+secs+",'"+surl+"')",1000);   
         }   
    else{   
         
         location.href=surl;   
         }    
    }   
    gou(5,"index.jsp");
</script>

<table class="tableDe">
    <%
        JDBCConnect jdbcConnect = new JDBCConnect();
        jdbcConnect.delete(request.getParameter("id"));
    %>
    <tr>
        <td>删除任务执行了</td>
        <td>

            5秒后跳转……
            <%request.getRequestDispatcher("index.jsp").forward(request,response);%>
        </td>
    </tr>
</table>