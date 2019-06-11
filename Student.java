
public class Student {
	private String name;
	private int age;
	private String gender;
	private double grade; //random between 2 and 6 and 2 decimals
	private int entityId;
	
	public Student(String name, int age,String gender, double grade, int entityId)
	{
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.grade = grade;
		this.entityId = entityId;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getGender()
	{
		return this.gender;
	}
	
	public double getGrade()
	{
		return this.grade;
	}
	
	public double calculatePayment(double avgGrade, int tax)
	{
		return this.age/avgGrade * 100 + tax;
	}
}
