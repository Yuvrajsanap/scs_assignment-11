package in.sp.beans;

public class Student {
	private int rollno;
	private String name;
	private Address address;

	// Constructor for constructor-based injection
	public Student(int rollno, String name, Address address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	public void display() {
		System.out.println("Roll no : " + rollno);
		System.out.println("Name : " + name);
		System.out.println("Address : " + address);
	}
}
