package laoshi;

import java.sql.*;

public class Manager {

	public static void main(String[] args) {
		new JDBCclass();
		// TODO Auto-generated method stub
//		Connection con = null;
//		Statement sql;
//		ResultSet rs;
//		try {
//			Class.forName("com.hxtt.sql.access.AccessDriver");
//			con=DriverManager.getConnection("jbdc:Access:///./Manager(1).accdb");
//		}
//		catch(Exception e){}
//		if(con!=null) {
//			System.out.print("6");
//		}
//		else {
//			System.out.print("n");
//		}
//		try {
//			sql=con.createStatement();
//			rs=sql.executeQuery("select * from teacher");
//			while(rs.next()) {
//				String number=rs.getString(1);
//				String name=rs.getString(2);
//				String sex=rs.getString(3);
//				System.out.printf("%s\t", number);
//				System.out.printf("%s\t", name);
//				System.out.printf("%s\t", sex);
//			}
//			con.close();
//		}
//		catch(SQLException e) {
//			System.out.println(e);
//		}
}
}

class JDBCclass{
	Connection con;
	Statement sql;
	ResultSet rs;
	
	public JDBCclass() {
		try {
			Class.forName("com.hxtt.sql.access.AccessDriver");
			con = DriverManager.getConnection("jdbc:Access:///sql\\Manager.accdb");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(con!=null) {
			System.out.printf("数据库连接成功！\n");
		}
		else {
			System.out.printf("数据库连接失败！\n");
		}
		
		try {
			sql=con.createStatement();
			rs=sql.executeQuery("select * from student");
			while(rs.next()) {
				String number=rs.getString(2);
				String name=rs.getString(4);
				String sex=rs.getString(5);
				String major=rs.getString(6);
				String tel=rs.getString(7);
				String score=rs.getString(8);
				System.out.printf("%s\n",number);
				System.out.printf("%s\n", name);
				System.out.printf("%s\n", sex);
				System.out.printf("%s\n",major);
				System.out.printf("%s\n", tel);
				System.out.printf("%s\n", score);
			}
			con.close();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
	}
}
