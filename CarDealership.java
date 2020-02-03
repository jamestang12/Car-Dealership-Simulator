import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class CarDealership {
	
	//Instance Variables
	private ArrayList<Car> cars;
	private double min , max;
	private boolean ElectricF , AWDF  , PriceF;
	
	
	

	
	
	/** CarDealership constructor method
	 * 	Sets up reference to instance variable arraylist
	 * @param CarObject
	 */
	public CarDealership(ArrayList<Car> CarObject)
	{
		cars = CarObject;
	}
	
	/** CarDealership constructor method
	 * 	Sets up reference to empty arraylist
	 */
	public CarDealership()
	{
		cars = new ArrayList<Car>(0);
	}
	
	/** addCars method to add the list of cars to that arraylist
	 * 
	 * @param newCars	The list of cars
	 */
	public void addCars(ArrayList<Car> newCars)
	{
		cars = newCars;
	}
	
	/** buycar method to remove the bought car from the arraylist
	 * 
	 * @param index		The index of the bought car
	 * @return			The bought car
	 */
	public Car buyCar(int index)
	{
		
		cars.remove(index);
		return cars.get(index);
	}
	/**
	 * Output the car item that been sold
	 * 
	 * @param index The index of the bought car
	 */
	public void displaySoldCar(int index)
	{
		String numSpace , Space , numLength;
			numSpace = "    ";
			Space = "";
			numLength = String.valueOf(index);
			for(int x1 = 0 ; x1 < numSpace.length() - numLength.length() ; x1++)
			{
				Space = Space + " ";
			}
		System.out.println(index + Space + cars.get(index).display());
	}
	
	/**	returnCar method to return a car to the list of available cars
	 * 
	 * @param car	The recently bought car
	 */
	public void returnCar(Car car)
	{
		cars.add(car);
	}
	/** displayInventory method to display cars
	 * 
	 */
	public void displayInventory()
	{
		
		ArrayList<Integer> carsChecker = new ArrayList<Integer>(0);
		/** When FAW is entered, cars with AWD will be added to the list		
		 */
		if(AWDF == true)
		{
			for(int x = 0 ; x < cars.size() ; x++)
			{
				if(cars.get(x).getAWD() == false)
				{
					carsChecker.add(x);
				}
			}
		}
		/** When FEL is entered, cars with FEL will be added to the list
		 */
		if(ElectricF == true)
		{
			for(int x = 0 ; x < cars.size() ; x++)
			{
				if(!(cars.get(x).getPower() == 0))
				{
					carsChecker.add(x);
				}
			}
		}
		/** When FPR is entered, cars within the price range will be added to the list
		 */
		if(PriceF == true)
		{
			for(int x = 0 ; x < cars.size() ; x++)
			{
				if(!(cars.get(x).getPrice() < max && cars.get(x).getPrice() > min))
				{
					carsChecker.add(x);
				}
			}
		}
		/** Printing out the list of cars
		 */
		for(int x = 0 ; x < cars.size(); x++)
		{
			if(!(carsChecker.contains(x)))
			{	
				
				String numSpace = "    ";
				String Space = "";
				String numLength = String.valueOf(x);
				for(int x1 = 0 ; x1 < numSpace.length() - numLength.length() ; x1++)
				{
					Space = Space + " ";
				}
				
				System.out.println(x + Space + cars.get(x).display());
			}
			else
			{
				continue;
			}
		}
		
		
	}
	
	public void filterByElectric()
	{
		ElectricF = true;
	}
	
	public void filterByAWD()
	{
		AWDF = true;
	}
	
	public void fillterByPrice(double minPrice , double maxPrice)
	{
		PriceF = true;
		min = minPrice;
		max = maxPrice;
		
	}
	
	public void FiltersClear()
	{
		ElectricF = AWDF = PriceF = false;
	}
	
	public void sortByPrice()
	{
		Collections.sort(cars);
	}
	
	public void sortBySafetyRating()
	{
		Collections.sort( cars , new Comparator<Car>()
		{
			public int compare(Car carA , Car carB)
			{
				return (int)(carB.getSafetyRating()*100 - carA.getSafetyRating()*100);
			}
		});
	}
	
	public void sortByMaxRange()
	{
		Collections.sort( cars , new Comparator<Car>()
		{
			public int compare(Car carA , Car carB)
			{
				return (int)(carB.getMaxRange() - carA.getMaxRange());
			}
		});
	}
	//Displaying all transactions
	public void dispayAllTransaction()
	{
		AccountingSystem2 accountingSystem = new AccountingSystem2();
		HashMap<Integer , Transaction> TranMap = new HashMap<>();
		TranMap = accountingSystem.getAllTranMap();
		//Checking if the hashmap is empty
		if(TranMap.isEmpty())
		{
			System.out.println("There are no transaction yet");
			System.out.println("");
		}
		else 
		{	
			for(int key : TranMap.keySet())
			{
				
				Transaction transaction = TranMap.get(key);
				System.out.println("_________________________________________________________________");
				transaction.displayTran();		
				System.out.println("_________________________________________________________________");

			}
		}

	}
	
	//Displaying the team of salesmen
	public void displayTeam()
	{
		String pile = "";
		LinkedList<String> list;
		SalesTeam salesTeam = new SalesTeam();
		list = salesTeam.getLinkedList();
		for(int x = 0 ; x < list.size() ; x++)
		{
			System.out.println(list.get(x));
		}
		System.out.println("");
	}
	
	/** getSalesOfTheMonth method 
	 * 
	 * @param month		The month that is being checked
	 */
	public void getSalesOfTheMonth(int month)
	{	int counter = 0;
		AccountingSystem2 accountingSystem = new AccountingSystem2();
		HashMap<Integer , String> MonthTran = new HashMap<Integer , String>();
		HashMap<Integer , Transaction> TranMap = new HashMap<Integer , Transaction>();
		TranMap = accountingSystem.getAllTranMap();
		MonthTran = accountingSystem.getMonthTran();
		if(!MonthTran.containsKey(month))
		{
			System.out.println("There are no transaction yet");
		}
		else
		{
			String value = MonthTran.get(month);
			Scanner scanner = new Scanner(value);
			while(scanner.hasNextInt())
			{
				int key = scanner.nextInt();
				Transaction transaction = TranMap.get(key);
				System.out.println("_________________________________________________________________");
				transaction.displayTran();
				System.out.println("_________________________________________________________________");
				counter++;
			}
			System.out.println("_________________________________________________________________");
			System.out.println("Number of transaction : " + counter);
			System.out.println("_________________________________________________________________");

			
		}
					
	}
	
	/* getAllSales method to display all sales 
	 */
	public void getAllSales()
	{
		
		AccountingSystem2 accountingSystem = new AccountingSystem2();
		HashMap<Integer , Double> SalesMap = new HashMap<>();
		SalesMap = accountingSystem.getSalesMap();
		int carSold = 0;
		if(SalesMap.isEmpty())
		{
			System.out.println("There are no sales yet");
		}
		else
		{
			double price = 0;
			for(int key : SalesMap.keySet())
			{
				price = price + SalesMap.get(key);
				carSold++;
			}
			System.out.println("The average sales is : " + "       " + price/12 );
			System.out.println("The total sales is: " + "          " + price);
			System.out.println("The number of car Sold: " + "      " + carSold);
		}
	}
	
	/** TOPSP method to display the top salesperson
	 */
	public void TOPSP()
	{
		String SalesPerson = "";
		int maxLength = 0;
		int counter = 0;
		HashMap<Integer , Transaction> TranMap = new HashMap<>(); 
		HashMap<String , String> SalesTran = new HashMap<>();
		AccountingSystem2 accountingSystem = new AccountingSystem2();
		TranMap = accountingSystem.getAllTranMap();
		SalesTran = accountingSystem.getSalesTran();
		if(SalesTran.isEmpty())
		{
			System.out.println("There is no sales yet");
		}
		else
		{
			for(String key : SalesTran.keySet())
			{
				int length = (SalesTran.get(key)).length();
				if(length > maxLength)
				{
					maxLength = length;
					SalesPerson = key;
				}
				
				else if(maxLength > 0 && length == maxLength)
				{
					SalesPerson = SalesPerson + " " + key;
				}
			}
			
			Scanner scanner3 = new Scanner(SalesPerson);
			String person = scanner3.next();
			String value1 = SalesTran.get(person);
			Scanner scan = new Scanner(value1);
			int taker;
			
			while(scan.hasNextInt())
			{
				taker = scan.nextInt();
				counter++;
			}
			
			Scanner scanner = new Scanner(SalesPerson);
			
			while(scanner.hasNext())
			{
				String name = scanner.next();
				System.out.println("_________________________________________________________________");
				System.out.println("Highest sales Person : " + name );
				System.out.println("Sales number : " + counter );
				System.out.println("_________________________________________________________________");
				String value = SalesTran.get(name);
				Scanner scanner2 = new Scanner(value);
				while(scanner2.hasNextInt())
				{
					
					Transaction Transaction = TranMap.get(scanner2.nextInt());
					System.out.println("_________________________________________________________________");
					Transaction.displayTran();
					System.out.println("_________________________________________________________________");

				}				
			}
		}	
	}
	
	/** displayTanNum method to display the transaction number
	 */
	public void displayTanNum()
	{
		Transaction transaction = new Transaction();
	}
	
	/** displayReturn for the return function
	 */
	public void displayReturn()
	{
		int key;
		AccountingSystem2 accountingSystem = new AccountingSystem2();
		key = accountingSystem.getRetrnKey();
		HashMap<Integer , Transaction> TranMap = new HashMap<>();
		TranMap = accountingSystem.getAllTranMap();
		Transaction Transaction = new Transaction();
		Transaction = TranMap.get(key);
		System.out.println("_________________________________________________________________");
		Transaction.displayTran();
		System.out.println("_________________________________________________________________");


	}
	/** displayBought method for the buy function
	 * 
	 */
	public void displayBought()
	{
		int key;
		AccountingSystem2 accountingSystem = new AccountingSystem2();
		key = accountingSystem.getRetrnKey();
		HashMap<Integer , Transaction> TranMap = new HashMap<>();
		TranMap = accountingSystem.getAllTranMap();
		Transaction Transaction = new Transaction();
		Transaction = TranMap.get(key);
		Transaction.displayTran();
	}
	/**highestMonth method for the highest month car sales
	 * 
	 */
	
	public void highestMonth()
	{
		AccountingSystem2 accountingSystem = new AccountingSystem2();
		HashMap<Integer , Transaction> TranMap = new HashMap<>();
		HashMap<Integer , String> MonthTran = new HashMap<>();
		MonthTran = accountingSystem.getMonthTran();
		TranMap = accountingSystem.getAllTranMap();
		String outPut = "";
		int max = 0;
		if(MonthTran.isEmpty())
		{
			System.out.println("There are no sales");
		}
		else
		{
			for(int key : MonthTran.keySet())
			{
				int size = (MonthTran.get(key)).length();
				if(size > max)
				{
					
					outPut = this.getMonth(key);
					max = size;
				}
				else if(size > 0 && size == max)
				{
					outPut = outPut + " " + this.getMonth(key);
				}
			}
		}
		
		if(!outPut.equals(""))
		{
			System.out.println("The highest sales month : " + "    " + outPut);
	
		}
	}
	
	/**totalRet method for the total retturn car
	 * 
	 */
	public void totalRet()
	{
		int count = 0;
		AccountingSystem2 accountingSystem = new AccountingSystem2();
		HashMap<Integer , Transaction> TranMap = new HashMap<>();
		TranMap = accountingSystem.getAllTranMap();
		for(int key : TranMap.keySet())
		{
			String type = TranMap.get(key).getType();
			if(type.equals("RET"))
			{
				count++;
			}
		}
		System.out.println("The total return is : " + "        " + count);
	}
	
	/**
	 * 
	 * @param month
	 * @return the name of the month
	 */
	private String getMonth(int month)
	{
		return new DateFormatSymbols().getMonths()[month-1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}