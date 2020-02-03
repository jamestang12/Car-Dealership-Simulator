//Ho Ming Tang
//500878800

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Transaction  {

	//Instance Variables
	private int TransactionNum , month , index;
	private String type , name , date;
	private Car car;
	SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM dd, yyyy");
		
	//An empty constructor
	public Transaction()
	{
		
	}
	
	/**	A constructor for Transaction
	 * 
	 * @param carObject			The Car object
	 * @param Transaction1		The transaction number
	 * @param type1				The type of transaction
	 * @param name1				The name of the sales person
	 * @param date1				The date of the transaction
	 * @param month1			The month of the transaction
	 */
	public Transaction( Car carObject , int Transaction1 , String type1 , String name1 , String date1 , int month1)
	{
		//this.index = index1;
		car = carObject;
		this.TransactionNum = Transaction1;
		this.type = type1;
		this.name = name1;
		this.date = date1;
		this.month = month1;	
	}
		
	/** getType method
	 * 
	 * @return type of transaction
	 */
	public String getType()
	{
		return this.type;
	}
	
	/** getSalesPersonName method
	 * 
	 * @return name of sales person
	 */
	public String getSalesPersonName()
	{
		return this.name;
	}
	
	/** getDate method
	 * 
	 * @return date of the transaction
	 */
	public String getDate()
	{
		return this.date;
	}
	
	/** TranNum method
	 * 
	 * @return transaction number
	 */
	public int TranNum()
	{
		return this.TransactionNum;
	}
	
	//Displaying the transaction
	public void displayTran()
	{
		System.out.format( "%-9S %28S"  ,"Date :"  , this.getDate());
		System.out.println("");
		System.out.format("%-9s %20s" , "Tranascation ID :" , this.TransactionNum);
		System.out.println("");
		System.out.format("%-9s %19s" , "Transaction type :" , this.getType());
		System.out.println("");
		System.out.format("%-9s %23s" , "Sales Person :" , this.getSalesPersonName());
		System.out.println("");
		System.out.format("%-9s %25s" , "Sale Price :" , car.getPrice());
		System.out.println("");

	}
	
	/** carObject method
	 * 
	 * @return car
	 */
	public Car carObject()
	{
		return this.car;
	}
	

	
}
