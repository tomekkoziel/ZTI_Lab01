package zti_lab.zti_lab01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReadFormData", value = "/ReadFormData")
public class ReadFormData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        String fname = request.getParameterValues("fname")[0] ;
        String lname = request.getParameterValues("lname")[0] ;
        String city = request.getParameterValues("city")[0] ;
        out.println("<h1>Dane przesłane z formularza</h1>") ;
        out.println("<table>") ;
        out.println("<tr><td>Marka: </td><td>" +  fname + "</td></tr>");
        out.println("<tr><td>Model: </td><td>" +  lname + "</td></tr>");
        out.println("<tr><td>Kraj pochodzenia: </td><td>" +  city + "</td></tr>");
        out.println("</body></html>");
    }
}