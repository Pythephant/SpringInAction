package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet{
	 private static final long serialVersionUID = 4601029764222607869L;
	 
     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html");
         resp.setCharacterEncoding("UTF-8");
         PrintWriter out = resp.getWriter();
         out.print("Hello world! 你好，世界！");
         out.flush();
         out.close();
     }
}
