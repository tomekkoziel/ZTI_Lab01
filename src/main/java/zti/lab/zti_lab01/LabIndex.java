package zti.lab.zti_lab01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LabIndex", value = "/LabIndex")
public class LabIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println ("<title>Reading and writing data to database</title>");

        out.println ("<h1>Reading and writing data to database</h1>");
        out.println ("<ol>");
        out.println ("<li><a href='FormData.html'>[Servlet] Read the data from the html form</a></li>");
        out.println ("<li><a href='ReadRecDB'>[Servlet (JDBC)] Read the records from the PostgreSQL database</a></li>");
        out.println ("</ol>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}