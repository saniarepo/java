/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp2;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Alexander
 */
public class DbServlet extends HttpServlet {

    String page = "filmlist.jsp";
 
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DbServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DbServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
 
        // Устанавливаем соединение с БД
 
        String connectionURL = "jdbc:mysql://127.0.0.1/symfony";
 
        Connection connection = null;
 
        ResultSet rs;
 
        response.setContentType("text/html");
 
        ArrayList dataList = new ArrayList();
 
        try {
 
            // Загружаем драйвер БД
 
            Class.forName("com.mysql.jdbc.Driver");
 
            // Подключаемся к БД
 
            connection = DriverManager.getConnection(connectionURL, "root",
                    "rootroot");
 
            // Выбираем данные из БД
 
            String sql = "select * from film";
 
            Statement s = connection.createStatement();
 
            s.executeQuery(sql);
 
            rs = s.getResultSet();
 
            while (rs.next()) {
 
                // Сохраняем всё в список
 
                dataList.add(rs.getInt("id"));
 
                dataList.add(rs.getString("name"));
 
            }
 
            rs.close();
 
            s.close();
 
        } catch (Exception e) {
 
            System.out.println("Exception is ;" + e);
 
        }
 
        request.setAttribute("data", dataList);
 
        // Переходим на JSP страницу
 
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
 
        if (dispatcher != null) {
 
            dispatcher.forward(request, response);
 
        }
 
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}