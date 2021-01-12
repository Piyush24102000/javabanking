

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class transfer1
 */
@WebServlet("/transfer1")
public class transfer1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transfer1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/plain");  
		PrintWriter out = response.getWriter();  
		          
		String name=request.getParameter("name"); 
		String name1 = request.getParameter("name1");
		String e =request.getParameter("amount");
		int f = Integer.parseInt(e);
		          

		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://127.0.0.1:3306/bank","root","");  
		              
		PreparedStatement ps=con.prepareStatement("select * from banking where name=?");  
		ps.setString(1,name);  
		              
		ResultSet rs=ps.executeQuery();  
		  int dataamount = 0;
		  if(rs.next()) {
			  dataamount = rs.getInt(6) - f;
			  
		  }
		  Class.forName("com.mysql.jdbc.Driver");  
		  Connection con1=DriverManager.getConnection(  
		  "jdbc:mysql://127.0.0.1:3306/bank","root","");  
			
		  PreparedStatement ps1=con1.prepareStatement("update banking set amount=? where name='"+name+"'");
			ps1.setInt(1, dataamount);
			ps1.executeUpdate();
			out.println("your balance has Decreased by Rs."+" "+ f);
			
			out.println("Your Updated Account balance is Rs."+" "+ dataamount);
//////////////////////
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con2=DriverManager.getConnection(  
			"jdbc:mysql://127.0.0.1:3306/bank","root","");  
			              
			PreparedStatement ps2=con2.prepareStatement("select * from banking where name=?");  
			ps2.setString(1,name);  
			              
			ResultSet rs1=ps2.executeQuery();  
			  int dataamount1 = 0;
			  if(rs1.next()) {
				  dataamount1 = f + rs.getInt(6);
				  
			  }
			  Class.forName("com.mysql.jdbc.Driver");  
			  Connection con3=DriverManager.getConnection(  
			  "jdbc:mysql://127.0.0.1:3306/bank","root","");  
				
			  PreparedStatement ps3=con3.prepareStatement("update banking set amount=? where name='"+name1+"'");
				ps3.setInt(1, dataamount1);
				ps3.executeUpdate();
				out.println("your balance has increased by Rs."+" "+ f);
				
				out.println("Your Updated Account balance is Rs."+" "+ dataamount1);
				    
				
			}
				catch (Exception e2) {e2.printStackTrace();}  
			          
			finally{out.close();}  
			  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
