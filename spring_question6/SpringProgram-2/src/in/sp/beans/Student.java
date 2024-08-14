package in.sp.beans;

public class Student {
	private int rollno;
    private String email;
    private String name;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void display() {
		System.out.println("Name : "+name);
		System.out.println("Email : "+email);
		System.out.println("rollno : " +rollno);
	}
}
