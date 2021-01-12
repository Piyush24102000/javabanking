

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		String name  = request.getParameter("name");
		  PrintWriter pw = response.getWriter();
		  try{  
			  Class.forName("com.mysql.jdbc.Driver");  
			  Connection con=DriverManager.getConnection(  
			  "jdbc:mysql://127.0.0.1:3306/bank","root","");  
		 
		  PreparedStatement ps = con.prepareStatement("delete from banking where name = '"+name+"'");
		  int i = ps.executeUpdate();
		 
		  if (i==0){
		  pw.println("Account has been deleted");
		  }
		  else{
		  pw.println("Account has been deleted");
		  }
		  }
		  catch(Exception e){
		  pw.println("The exception is " + e);
		  }
		  }
	}

	
