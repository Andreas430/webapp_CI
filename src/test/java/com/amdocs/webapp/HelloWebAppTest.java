package com.amdocs.webapp;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class HelloWebAppTest {

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    


        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

	BasicCalculator calc = mock(BasicCalculator.class);
        new HelloWebApp(calc).doGet(request, response);
        
        writer.flush(); // it may not have been flushed yet...
        System.out.print(stringWriter.toString());
        assertTrue("MainPage",stringWriter.toString().contains("Hello Limassol"));
    }

    @Test
    public void testAvg() throws Exception {
	BasicCalculator calc = mock(BasicCalculator.class);
	when(calc.add(4, 6)).thenReturn(10);
	int k = new HelloWebApp(calc).avg(4, 6);
	assertEquals("Avg", 5, k);
    }

}
