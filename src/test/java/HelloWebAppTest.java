package com.amdocs.webapp;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class HelloWebAppTest extends Mockito{

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    


        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new HelloWebApp().doGet(request, response);
        
        writer.flush(); // it may not have been flushed yet...
        System.out.print(stringWriter.toString());
        assertTrue("MainPage",stringWriter.toString().contains("Hello Limassol"));
    }

    @Test
    public void testAdd() throws Exception {

        int k= new HelloWebApp().add(5,5);
        assertEquals("Add", 10, k);
        
    }
   
    public void testSub() throws Exception {

        int k= new HelloWebApp().sub(8,7);
        assertEquals("Sub", 1, k);

    }
}
