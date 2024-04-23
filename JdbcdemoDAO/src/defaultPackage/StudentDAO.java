package defaultPackage;
import java.sql.*;

public class StudentDAO {
	Connection con = null;
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Mydatabase";
			String user = "root";
			String password = "system";
			con = DriverManager.getConnection(url,user,password);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void closeConnection() {
		try {
			con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public Student getSname(int rollno) {
		Student s = new Student();
		String query = "select sname from student where rollno = "+rollno;
		s.setRollno(rollno);
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			s.setSname(rs.getString(1));
			//System.out.println(s.getRollno()+": "+s.getSname());
			st.close();
			return s;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}

		return null;
		
	}

	public void addStudent(Student s) {
		String query = "insert into student values(?,?)";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, s.getRollno());
			st.setString(2, s.getSname());
			int res = st.executeUpdate();
			if(res>0) {
				System.out.println(res +" row/s updated.");
			}
			else {
				System.out.println("Error while updating table");
			}
			st.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	public void deleteStudent(int rollno) {
		String query ="delete from student where rollno ="+rollno;
		try {
			Statement st = con.createStatement();
			st.execute(query);
			st.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
}
