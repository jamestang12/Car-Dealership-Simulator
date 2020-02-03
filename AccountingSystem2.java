//Ho Ming Tang
//500878800
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class AccountingSystem2 {
	
	//Instance Variables
	private Car car;
	private int transactionNum , month ;
	private String type ,name , date;
	//Format for the date
	SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMM dd, yyyy");
	
	//Using a hashmap for the bonus
	static HashMap<Integer , Transaction> TranMap = new HashMap<>();
	static HashMap<String , String> SalesTran = new HashMap<>();
	static HashMap<Integer , String> MonthTran = new HashMap<>();
	static HashMap<Integer , Double> SalesMap = new HashMap<>();
	static HashMap<Integer , Integer> Transactionchecker = new HashMap<>();
	static int returnKey = 0;
	
	//An empty constructor
	public AccountingSystem2()
	{
		
	}
	
	/** A constructor for AccountingSystem2
	 * 
	 * @param carObject		The Car object
	 * @param type1			The type of transaction
	 * @param name1			The name of the sales person
	 * @param date1			The date of the transaction
	 * @param month1		The month of the transaction
	 */
	public AccountingSystem2(Car carObject  , String type1 , String name1 , Calendar date1 , int month1)
	{
		
		car = carObject;
		transactionNum = this.getTransaction();
		type = type1;
		name = name1;
		date = sdf.format(date1.getTime());
		month = month1;	
		
		//If the transaction is BUY
		if(type.equals("BUY"))
		{
			
			if(SalesTran.containsKey(name))
			{
				String value = SalesTran.get(name);
				value = value + " " + String.valueOf(transactionNum);
				SalesTran.put(name, value);
			}
			
			else if(!(SalesTran.containsKey(name)))
			{
				SalesTran.put(name , String.valueOf(transactionNum));
			}
			
			returnKey = transactionNum;
			double price = car.getPrice();
			SalesMap.put(transactionNum , price );
			
		}
		this.add(transactionNum, new Transaction(car , transactionNum , type , name , date , month));
	
		if(MonthTran.containsKey(month))
		{
			String value = MonthTran.get(month);
			value = value + " " + String.valueOf(transactionNum);
			MonthTran.put(month , value);
		}
		
		else if(!(MonthTran.containsKey(month)))
		{
			MonthTran.put(month , String.valueOf(transactionNum));
		}
	
	}
	
	/**
	 * 
	 * @param add
	 * @param add an object into the hashmap
	 */
	public void add(int id , Transaction object )
	{
		TranMap.put(id, object);
	}
	
	/**getAllTranMap
	 * 
	 * @return the AllTranMap hashmap
	 */
	public HashMap<Integer , Transaction> getAllTranMap()
	{
		
		return TranMap;
	}
	/**getSalesTran
	 * 
	 * @return the getSalesTran hashmap
	 */
	public HashMap<String , String> getSalesTran()
	{
		
		return SalesTran;
	}
	
	/**getSalesMap
	 * 
	 * @return getSalesMap hashmap
	 */
	public HashMap<Integer , Double> getSalesMap()
	{
		return SalesMap;
	}
	
	/**getMonthTran
	 * 
	 * @return getMonthTran hashmap
	 */
	public HashMap<Integer , String> getMonthTran()
	{
		return MonthTran;
	}
	
	/** HighestSalesMonth method displaying the month with the highest sales
	 * 
	 * @return	the month with the highest sales
	 */
	public String HighestSalesMonth()
	{
		int max = 0 ;
		String value;
		String maxKey = "There are no sales yet";
		for(int key : MonthTran.keySet())
		{
			value = MonthTran.get(key);
			if(value.length() > max)
			{
				maxKey = String.valueOf(key);
			}
			
			else if(max > 0 && value.length() == max)
			{
				maxKey = maxKey + " " + String.valueOf(key);
			}
		}
		
		return maxKey;
	}
	
	/** getRetrnKey method
	 * 
	 * @return	returnKey
	 */
	public int getRetrnKey()
	{
		return returnKey;
	}
	
	/** getTransaction method
	 * 
	 * @return	transaction
	 */
	public int getTransaction()
	{
		int transaction = (int)(Math.random()*98) + 1;
		while(Transactionchecker.containsKey(transaction))
		{
			transaction = (int)(Math.random()*98) + 1;
		}
		Transactionchecker.put(transaction , 1);
		return transaction;
		
	}
	
}
