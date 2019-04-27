package Service;


import Dao.JDBCConnect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class updateClass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JDBCConnect jdbcConnect = new JDBCConnect();
            jdbcConnect.updateById(Integer.parseInt(req.getParameter("id")),req.getParameter("name"),req.getParameter("birDate"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
     req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

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
