package zti_lab.zti_lab01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


import java.io.*;

        import jakarta.servlet.http.*;
        import jakarta.servlet.annotation.*;

@WebServlet(name = "demoServlet", value = "/demo-servlet")
public class DemoServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println ("\nWelcome, First Servlet<br>\n");
        out.println ("<a href=\"localhost:8085/ZTI_Lab01_war_exploded/demo-servlet\">Demo Servlet</a>");
    }

    public void destroy() {
    }
}
