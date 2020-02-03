//Ho Ming Tang
//500878800
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class SalesTeam 
{
	//Instance Variables
	private int x;
	private ArrayList<Car> cars;
	LinkedList<String> names;
	private int checker = 0;
	
	/** A constructor for SalesTeam
	 * 
	 */
	public SalesTeam()
	{
		if(checker == 0)
		{
			names = new LinkedList<String>();
			names.add("James");
			names.add("Robert");
			names.add("Ryan");
			names.add("Mango");
			names.add("Eric");
		}
		
		checker++;

	}
	
	/** SalesName method to return the name of a random salesperson
	 * 
	 * @return	salesperson
	 */
	public String SalesName()
	{
		x = (int)(Math.random()*4);
		ListIterator<String> iter = names.listIterator();
		for(int y = 0 ; y < x ; y++)
		{
			iter.next();
		}
		return iter.next();
	}
	
	/** getLinkedList method to return the name of the team
	 * 
	 * @return list of names
	 */
	public LinkedList<String> getLinkedList()
	{
		return names;
	}
	
}
