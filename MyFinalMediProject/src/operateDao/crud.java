package operateDao;

import java.sql.*;
import java.util.ArrayList;

import connect.GetConnection;
import model.ambulance;
import model.showblood;

public class crud {
	
	public static int addUsrreg(String first,String last,String email,String phone,String password,String reEnterPass) {
		int status=0;
		try {
			Connection con=GetConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO usr_reg ( fname, lname, email, phone, password, reEnterPass) values(?,?,?,?,?,?) ");
			ps.setString(1, first);
			ps.setString(2, last);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, password);
			ps.setString(6, reEnterPass);
			
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
		
	}


public static int addVenderreg(String first,String last,String email,String phone,String venderName,String address,String pincode ,String password,String glink) {
	int status=0;
	try {
		Connection con=GetConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("INSERT INTO vender_reg ( fname, lname, email, phone, venderName, address, pincode, password, glink) values(?,?,?,?,?,?,?,?,?) ");
		ps.setString(1, first);
		ps.setString(2, last);
		ps.setString(3, email);
		ps.setString(4, phone);
		ps.setString(5, venderName);
		ps.setString(6, address);
		ps.setString(7, pincode);
		ps.setString(8, password);
		ps.setString(9, glink);

		status=ps.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	}
	return status;


}

 public static boolean login(String sql,String userName,String pass) throws ClassNotFoundException, SQLException
{
	int userCount=0;
	int falseCount=0;
	Connection con=GetConnection.getConnection();
	Statement st=con.createStatement();
	ResultSet rs=null;
	rs = st.executeQuery(sql);
	while(rs.next()){
		userCount++;
	String dbUserName =	rs.getString("email");
	String dbpswd =	rs.getString("password");	
	if(userName.equals(dbUserName)&&pass.equals(dbpswd))
	{
	  return true;	
	}
	else
	{
		falseCount++;
	}
	}
	
	if(falseCount==userCount)
	{
		falseCount =0;
		return false;
	}
	
	falseCount=0;
	
	return true;
}
 
 public static int addProd(String pid,String pname,String mname,String mft_date,String exp_date,String power,String quantity,String price,String pincode,String shope_owner) {
	 int status=0;
	 try {
		  Connection con=GetConnection.getConnection();
		  PreparedStatement ps=con.prepareStatement("INSERT INTO tbl_product (pid, pname, mname, mft_date, exp_date, power, quantity, price,pincode,shope_owner) values(?,?,?,?,?,?,?,?,?,?) ");
		  ps.setString(1, pid);
		  ps.setString(2, pname);
		  ps.setString(3, mname);
		  ps.setString(4, mft_date);
		  ps.setString(5, exp_date);
		  ps.setString(6, power);
		  ps.setString(7, quantity);
		  ps.setString(8, price);
		  ps.setString(9, pincode);
		  ps.setString(10, shope_owner);
		  status=ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return status;
}
 
 public static int deleteProd(int pid){
	 int status=0;
	 try {
		 Connection con=GetConnection.getConnection();
		 PreparedStatement ps=con.prepareStatement("DELETE FROM tbl_product WHERE pid=?");
		 ps.setInt(1, pid);
		 
		 status=ps.executeUpdate();
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return status;
 }

	public static int updateProd(String pid, String pname, String mname, String mft_date, String exp_date,
								 String power, String quantity, String price) {
		int status = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = GetConnection.getConnection();
			ps = con.prepareStatement(
					"UPDATE tbl_product SET pname=?, mname=?, mft_date=?, exp_date=?, power=?, quantity=?, price=? WHERE pid=?"
			);

			ps.setString(1, pname);
			ps.setString(2, mname);
			ps.setString(3, mft_date);
			ps.setString(4, exp_date);
			ps.setString(5, power);

			// Parse quantity as integer
			ps.setInt(6, Integer.parseInt(quantity));

			// Parse price as BigDecimal
			ps.setBigDecimal(7, new java.math.BigDecimal(price));

			ps.setString(8, pid);

			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}



 public static String getPin(String vMail) throws SQLException
 {
	 String pin=null;
	    Connection con=GetConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=null;
		rs = st.executeQuery("SELECT * FROM vender_reg where email='"+vMail+"'");
		while(rs.next()){
		pin=rs.getString(8);
		}
	return pin; 
 }


	public static int addblood(String name,String address,int age,String gender,String bloodType) {
		int status=0;
		try {
			Connection con=GetConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO temp_blood ( name, address, age, gender, bloodType) values(?,?,?,?,?) ");
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setInt(3, age);
			ps.setString(4, gender);
			ps.setString(5, bloodType);

			status=ps.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static ArrayList<showblood> getAllBloodDonors()
	{
		ArrayList<showblood> bloodDonors = new ArrayList<>();
		try {
			// Establish connection to the database
			Connection con = GetConnection.getConnection();
			Statement st=con.createStatement();
			// PreparedStatement ps = con.prepareStatement("SELECT * FROM temp_blood");

			ResultSet rs = st.executeQuery("SELECT * FROM temp_blood");

			while (rs.next()) {

				// Create a new BloodDonor object and add it to the list
				showblood donor = new showblood(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				bloodDonors.add(donor);
			}

			// Close ResultSet, PreparedStatement, and Connection
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bloodDonors;
	}


	public static int ambulancebook(String name,String ph_no,String destination,String pickup_location,String date_time) {
		int amb=0;
		try {
			Connection con=GetConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO ambulance (name,ph_no,destination,pickup_location,date_time) values(?,?,?,?,?) ");
			ps.setString(1, name);
			ps.setString(2, ph_no);
			ps.setString(3, destination);
			ps.setString(4, pickup_location);
			ps.setString(5, date_time);

			amb=ps.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return amb;


	}



	public static ArrayList<ambulance> ambulanceshow() {

		ArrayList<ambulance> al=new ArrayList<>();
		try {
			Connection con=GetConnection.getConnection();
			Statement st=con.createStatement();


			ResultSet rs=st.executeQuery("SELECT * FROM ambulance");
			while (rs.next())
			{
				ambulance a=new ambulance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				al.add(a);

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return al;


	}


}


