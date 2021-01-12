import java.io.*;  
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class bankfinal extends HttpServlet {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          

try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://127.0.0.1:3306/bank","root","");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into banking values(?,?,?,?,?,?)");  
  

String a =request.getParameter("name");
String b=request.getParameter("password");
String c =request.getParameter("repassword");
String d =request.getParameter("address");

String g  =request.getParameter("phone");
double h = Double.parseDouble(g);

String e =request.getParameter("amount");
int f = Integer.parseInt(e);


ps.setString(1,a);
ps.setString(2,b);
ps.setString(3,c);
ps.setString(4,d);
ps.setDouble(5, h);
ps.setInt(6, f);

int i=ps.executeUpdate();  
if(i>0){
	
	RequestDispatcher rd=request.getRequestDispatcher("/new1.html");
	rd.include(request, response);
}
else{
	out.print("Sorry,Registration failed. please try later");
	RequestDispatcher rd=request.getRequestDispatcher("/index.html");
	rd.include(request, response);
}

}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  