
public class Institution {
	private int id;
	private String name;
	private String address;
	
	public Institution(int id, String name, String address) 
	{
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public String getName()
	{
		return this.name;
	}
}
