package Service;

import Dao.JDBCConnect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* insert文件
* insert请求在此接收前台insert.jsp传来的数据
* 调用JDBCConnect类中的insert(Integer id,String name,String birDate,boolean gander)方法完成向数据库添加数据的功能
* */
public class insert extends HttpServlet {
    //重写doPost方法
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //接收来自insert.jsp的数据，调用insert方法
            JDBCConnect jdbcConnect = new JDBCConnect();
            jdbcConnect.insert(Integer.parseInt(request.getParameter("id")),request.getParameter("name"),request.getParameter("birDate"),true);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //向后台返回插入数据所对应的id，便于发现问题和后期管理
        System.out.println("加入了数据 ,id = " + Integer.parseInt(request.getParameter("id")));
        //重定向到index.jsp
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
