package Service;


import Dao.JDBCConnect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 向servlet发送update请求
public class updateClass extends HttpServlet {
    // 重写doGet方法，连接数据库
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JDBCConnect jdbcConnect = new JDBCConnect();
            jdbcConnect.updateById(Integer.parseInt(req.getParameter("id")),req.getParameter("name"),req.getParameter("birDate"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
     // 重定向到初始index.jsp页面
     req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    // 重写doPost方法，连接数据库，根据id更新name和birDate
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JDBCConnect jdbcConnect = new JDBCConnect();
            jdbcConnect.updateById(Integer.parseInt(req.getParameter("id")),req.getParameter("name"),req.getParameter("birDate"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
