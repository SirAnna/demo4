package com.example.demo4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.valueOf;

@WebServlet(name = "Servlet3", value = "/S3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context=getServletContext();
        Integer times=(Integer) context.getAttribute("times");
        if(times==null){
            times=valueOf(1);
        }
        else{
            times=valueOf(times.intValue()+1);
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out1=response.getWriter();

        out1.println("<html><head><title>");
        out1.println("页面访问统计");
        out1.println("</title></head><body>");
        out1.println("当前页面被访问了");
        out1.println("<font color=blue size=20>"+times+"</font>次");
        out1.println("</body></html>");
        context.setAttribute("times",times);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
