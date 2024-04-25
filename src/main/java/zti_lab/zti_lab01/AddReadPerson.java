package zti_lab.zti_lab01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



@WebServlet(name = "AddReadPerson", value = "/AddReadPerson")
public class AddReadPerson extends HttpServlet {

    protected void readRecords(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> persons = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://azurepostgresql-zti.postgres.database.azure.com:5432/postgres";
            String username = "azureuser" ;
            String password = "J@5hD@K9884wTwh" ;

            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            System.out.println("fname");
            String sql = "SELECT * FROM cars";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String fname = rs.getString("FNAME");
                String lname = rs.getString("LNAME");
                String city = rs.getString("CITY");
                Person person = new Person(fname, lname, city);
                persons.add(person);
                System.out.println("fname");
                System.out.println(fname);           }

            rs.close();
            stmt.close();
            conn.close();

            request.setAttribute("persons", persons);
            ServletContext sc = getServletConfig().getServletContext();
            RequestDispatcher rd = null;
            rd = sc.getRequestDispatcher("/mvc/Site3.jsp");
            rd.forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        readRecords(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        String fname = request.getParameterValues("fname")[0] ;
        String lname = request.getParameterValues("lname")[0] ;
        String city = request.getParameterValues("city")[0] ;
    try {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://azurepostgresql-zti.postgres.database.azure.com:5432/postgres";
        String username = "azureuser" ;
        String password = "J@5hD@K9884wTwh" ;
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "INSERT INTO cars(fname, lname, city) VALUES ('" + fname + "', '" + lname + "', '" + city + "')";

PreparedStatement stmt = conn.prepareStatement( sql );
stmt.executeUpdate();

        stmt.close();
        conn.close();
        ServletContext sc = getServletConfig().getServletContext();
        RequestDispatcher rd = null;
        rd = sc.getRequestDispatcher("/mvc/Site2.jsp");
        rd.forward(request, response);

    }
    catch(Exception e)
    {  out.println (e) ; }
}
}