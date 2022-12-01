package com.amdocs.webapp;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Date;

public class HelloWebApp extends HttpServlet {

	private BasicCalculator calc;

	private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	         throws ServletException, IOException {
            resp.setContentType("text/plain");
            resp.getWriter().write("Hello Limassol! Andreas\n\n\nJava Project for DevOps hands-on Workshop.\n\n\n");
        }


	public HelloWebApp() {
		this.calc = null;
	}

	public HelloWebApp(BasicCalculator calc) {
		this.calc = calc;
	}

	public int avg(int a, int b) {
	    return calc.add(a, b)/2;
	}

}
