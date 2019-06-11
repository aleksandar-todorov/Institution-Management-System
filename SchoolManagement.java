import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SchoolManagement {
	public static void main(String args[])
	{
		School school1 = new School(1, "MG Petar Beron", "Chaika");
		School school2 = new School(2, "Dimcho Debelqnov", "Center");
		School school3 = new School(3, "4th high school", "Briz");

		University university1 = new University(4, "TU Varna", "Studenska str 1");
		University university2 = new University(5, "Free Varna Uni", "Golden Sands");
		
		List<Institution> institutions = new ArrayList<>();
		
		institutions.add(school1);
		institutions.add(school2);
		institutions.add(school3);
		institutions.add(university1);
		institutions.add(university2);

		List<Student> students = new ArrayList<>();
		
		for (int i = 1; i < 51; i++) //creating 50 Students
		{
			String name = "Student" + i;
			int age = i + 10;
			String gender = "male";
			if (i % 2 == 0) 
			{
				gender = "female";	
		    }
			
			Random r = new Random();
			double grade = 2 + (6 - 2) * r.nextDouble();
			DecimalFormat df = new DecimalFormat("#.##");
			grade = Double.parseDouble(df.format(grade));
			
			int entityId = (i - 1) / 10 + 1;
			
			students.add(new Student(name, age, gender, grade, entityId)); // students are from 0 to 49
			
			String insitutionName = institutions.get(entityId -1).getName();
			
			System.out.println("Hello " + students.get(i - 1).getName() + " and welcome to " + insitutionName);
		}
		
		double topGrade = 0;
		String topStudentName = "";
		double topMaleGrade = 0;
		String topMaleStudentName = "";
		double topFemaleGrade = 0;
		String topFemaleStudentName = "";
		double totalIncome = 0;
		double topContribution = 0;
		String topContributorName = "";
		
		for (int i = 0; i < 5; i++) 
		{
			double sumGrade = 0;
			for(int j = 1; j < 11; j++) 
			{
				double currentGrade = students.get(i*10 + j - 1).getGrade();
				sumGrade += currentGrade;
				if(currentGrade > topGrade)
				{
					topGrade = currentGrade;
					topStudentName = students.get(i*10 + j - 1).getName();
				}
				
				if(j%2 == 0) 
				{
					if(currentGrade > topFemaleGrade)
					{
						topFemaleGrade = currentGrade;
						topFemaleStudentName = students.get(i*10 + j - 1).getName();
					}
				}
				else 
				{
					if(currentGrade > topMaleGrade)
					{
						topMaleGrade = currentGrade;
						topMaleStudentName = students.get(i*10 + j - 1).getName();
					}
				}
			}
			
			System.out.printf("Avarage grade from all students in %s is: %.2f %n", institutions.get(i).getName() , sumGrade/10);
			
			
			if(i <= 3 ) {
			for(int j = 1; j < 11; j++) 
				{
				double currentContribution = students.get(i*10 + j - 1).calculatePayment(sumGrade/10, 50);
				totalIncome += 	currentContribution;
				if(currentContribution > topContribution)
				{
					topContribution = currentContribution;
					topContributorName = students.get(i*10 + j - 1).getName();
				}
				}
			}
			else 
			{
				for(int j = 1; j < 11; j++) 
				{
					double currentContribution = students.get(i*10 + j - 1).calculatePayment(sumGrade/10, 100);
					totalIncome += 	currentContribution;	
					if(currentContribution > topContribution)
					{
						topContribution = currentContribution;
						topContributorName = students.get(i*10 + j - 1).getName();
					}
				}
			}
		}
		
		System.out.printf("The top performing Student is %s with grade: %.2f %n", topStudentName, topGrade);
		System.out.printf("The top performing female Student is %s with grade: %.2f %n", topFemaleStudentName, topFemaleGrade);
		System.out.printf("The top performing male Student is %s with grade: %.2f %n", topMaleStudentName, topMaleGrade);
		System.out.printf("The total income from all schools and unis are : %.2f %n", totalIncome);
		System.out.printf("The top contributor's name is: %s", topContributorName);
		
	}
}
