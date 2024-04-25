package zti_lab.zti_lab01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

@WebServlet(name = "ReadRecDB", value = "/ReadRecDB")
public class ReadRecDB extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        out.println("<h1>Dane z bazy danych PostgreSQL - AzureDB</h1>") ;

        try
        {
            // Class.forName("org.apache.derby.jdbc.ClientDriver");
            // url = "jdbc:postgresql://host:port/database"
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://azurepostgresql-zti.postgres.database.azure.com:5432/postgres";
            String username = "azureuser" ;
            String password = "J@5hD@K9884wTwh" ;
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM cars";
            ResultSet rs = stmt.executeQuery( sql );
            out.println("<table>") ;
            out.println("<tr><th>Lp.</th><th>Marka</th><th>Model</th><th>Kraj pochodzenia</th></tr>") ;
            while(rs.next())  {
                out.print("<tr><td>" + rs.getInt("ID") + "</td><td>" + rs.getString("FNAME") + "</td>" ) ;
                out.println ( "<td>" + rs.getString("LNAME") + "</td><td>" + rs.getString("CITY") + "</td></tr>" ) ;
            }
            out.println("</table>") ;
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {  out.println (e) ; }

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        processRequest(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(request, response);
    }
}