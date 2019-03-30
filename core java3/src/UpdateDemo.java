import java.sql.*;
import java.util.*;
public class UpdateDemo {

	public static void main(String[] args) {
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		int cnt=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");   
	        con= DriverManager.getConnection("jdbc:MySql://localhost:3307/classicmodels",
					"root","root");
	    	
		String strUpdate = "UPDATE employees "+"SET jobTitle= ? "+"WHERE employeeNumber =?";
		pstmt=con.prepareStatement(strUpdate);
		
		//prepare data for update
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Employee Id:");
		int eid=sc.nextInt();//1702
		sc.nextLine();
		System.out.println("enter new job title :");
		String strm=sc.nextLine(); //sales Manager
		
		pstmt.setString(1, strm);
		pstmt.setInt(2, eid);
		
		int rowAffected = pstmt.executeUpdate();
		System.out.println("Row affected"+rowAffected);
		
		//reuse the prepared statement
		strm = "Sales head";
		eid = 1370;
		pstmt.setString(1, strm);
		pstmt.setInt(2,eid);
		
		rowAffected = pstmt.executeUpdate();
		System.out.println("Row affected"+rowAffected);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}