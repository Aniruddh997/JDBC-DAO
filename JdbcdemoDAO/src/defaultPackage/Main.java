package defaultPackage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDAO dao = new StudentDAO();
		dao.connect();
		Student s1 = dao.getSname(2);
		System.out.println(s1.getSname());
		
		Student s2 = new Student();
		s2.setRollno(7);
		s2.setSname("Ravina");
		dao.connect();
		dao.addStudent(s2);
		
		dao.deleteStudent(7);
		dao.closeConnection();
	}

}
