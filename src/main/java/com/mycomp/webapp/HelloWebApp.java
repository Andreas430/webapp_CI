package com.mycomp.webapp;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Date;

public class HelloWebApp extends HttpServlet {

	private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	         throws ServletException, IOException {
            resp.setContentType("text/plain");
            resp.getWriter().write("Hello World! Maven Web Project Example.");
        }


        public int add(int a, int b) {
            return a + b;
        }

	public int rem(int a, int b) {
            return a - b;
        }

}
