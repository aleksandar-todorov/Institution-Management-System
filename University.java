
public class University extends Institution{
	
	private static final int TAX = 100;

	public University(int id, String name, String address) 
	{
		super(id, name, address);
	}
	
	@Override
	public int getTax()
	{
		return TAX;
	}
}
