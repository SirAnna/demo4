package com.example.demo4;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name="HelloServlet",value="/hello-servlet")
public class HelloServlet implements Servlet {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:49155/base1?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "18978909834";
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;

        PrintWriter out=servletResponse.getWriter();
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("connect successfully");
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT*FROM t1");
            rs.next();
            out.println(rs.getString(1)+"\t"+rs.getString(2));
        } catch (SQLException e) {
            out.println(e);
            out.println("connect error");
        }catch (ClassNotFoundException e){
            out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
