package com.company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SendServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try{
            out.println("About is "+getServletInfo());//здесь мы выводим информацию о сервлете
            init();//вызываем инит метод
            resp.sendRedirect("https://www.carshop.co.uk/");//перенаправляем на эту ссылку
        }
        finally {
            out.close();
        }

    }
}
