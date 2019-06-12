
public class Institution {
	
	private static final int TAX = 50;

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
	
	public int getTax()
	{
		return TAX;
	}
}
