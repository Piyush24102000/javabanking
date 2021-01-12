import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class balance extends HttpServlet {  
  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String name=request.getParameter("name");  
          

try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://127.0.0.1:3306/bank","root","");  
              
PreparedStatement ps=con.prepareStatement("select * from banking where name=?");  
ps.setString(1,name);  
              
 
out.print("<caption>Result:</caption>");  
  
ResultSet rs=ps.executeQuery();  
              

/* Printing result */  
  
while(rs.next())  
{  
out.print("Your account balance is Rs."+" "+ rs.getInt(6));  
                  
}  
  
              
}catch (Exception e2) {e2.printStackTrace();}  
          
finally{out.close();}  
  
}  
}  