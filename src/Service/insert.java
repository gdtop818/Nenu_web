package Service;

import Dao.JDBCConnect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class insert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JDBCConnect jdbcConnect = new JDBCConnect();
            jdbcConnect.insert(Integer.parseInt(request.getParameter("id")),request.getParameter("name"),request.getParameter("birDate"),true);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(Integer.parseInt(request.getParameter("id")));
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
