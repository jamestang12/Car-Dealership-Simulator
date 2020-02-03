//Ho Ming Tang
//500878800

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class CarDealershipSimulator {

	public static void main(String[] args)throws IOException {
		
		//The list of new cars
		ArrayList<Car> newCars = new ArrayList<Car>();
		
		//The list of sold cars
		ArrayList<Car> SoldCars = new ArrayList<Car>();
		SoldCars.add(null);
		
		//The list of VIN to check
		ArrayList<Integer> VINchecker = new ArrayList<Integer>();
		
		//Formatting for the date
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMM dd, yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE MM dd, yyyy");
		
		//A month in the year
		int month = (int)(Math.random()*4)+1;
		
		//A day in the montth
		int day2 = (int)(Math.random()*25)+1;
		
		//The calendar
		Calendar calendar = new GregorianCalendar(2019,month,day2);
		Scanner scanner = new Scanner(System.in);
		boolean tester = true;
		CarDealership car = new CarDealership();
		/** When tester is true, simulator will run
		 */
		while(tester)
		{
			try {
				System.out.println("Please enter an input");
				Scanner scanner2 = new Scanner(scanner.nextLine());
				String input = scanner2.next();
				//Press Q to quit
				if(input.equals("Q") || input.equals("q"))
				{
					tester = false;
					//System.out.println("No u");
				}
				
				
				//When user entered SALES
				else if(input.equals("SALES"))
				{	
					String value = "";
					if(!scanner2.hasNext())
					{
						car.dispayAllTransaction();
						continue;
					}
					
					else if(scanner2.hasNextInt())
					{
						int index = scanner2.nextInt();
						if(index >=1 && index <= 12)
						{
							
							car.getSalesOfTheMonth(index);
							
						}
						
					}
					
					else if(scanner2.hasNext())
					{
						value = scanner2.next();
						
						//If user entered TEAM
						if(value.equals("TEAM"))
						{
							car.displayTeam();
							continue;
						}
						
						//If user entered TOPSP
						else if(value.contains("TOPSP"))
						{
							car.TOPSP();
							continue;
						}
						
						
						else if(!(value.equals("STATS")))
						{
							continue;
						}
						
						//If user entered STATS
						else if(value.equals("STATS"));
						{
							car.getAllSales();
							car.highestMonth();
							car.totalRet();
							continue;
						}		
		
					}
					
					continue;

				}
	
				//If user entered ADD
				else if(input.equals("ADD"))
				{
					for(int x = 0 ; x < 3 ; x++)
					{	
					try 
					{
								Scanner scanner3 = new Scanner(new File("cars.txt")); //scanner for file 
								while(scanner3.hasNextLine())
								 {
									//VIN Generator
									int VIN = (int)(Math.random()*399) + 100 ;
									while(VINchecker.contains(VIN))
									{
										VIN = (int)(Math.random()*399) + 100 ;
									}
									VINchecker.add(VIN);
								
									//Creating a new Car object from the file
									boolean AWD = false;
									 String mfr = scanner3.next();
									 String color = scanner3.next();
									 Car.model model = Car.model.valueOf(scanner3.next());
									 String powerTester = scanner3.next();
									 Vehicle.power power = Vehicle.power.valueOf(powerTester);
									 double SR = scanner3.nextDouble();
									 int range = scanner3.nextInt();
									 String AWDTester = scanner3.next();
									 if(AWDTester.equals("AWD"))
									 {
										 AWD = true;
									 }
									 double price = scanner3.nextDouble(); 
									 if(powerTester.equals("ELECTRIC_MOTOR"))
									 {
										 int time = scanner3.nextInt();
										 String battery = "Lithium";
										 newCars.add(new ElectricCar(VIN , mfr , color , model , power , SR , range, AWD , price , time , battery ));
									 }
									 else
									 {
										 newCars.add(new Car(VIN , mfr , color , model , power , SR , range, AWD , price ));
									 }		 
									 
								 }
					}catch(Exception e) {System.out.println(e);}

					car.addCars(newCars);
					}
					System.out.println();
				}
				//Output list of cars
				else if(input.equals("L"))
				{
					System.out.println("");
					System.out.format("%-2s %6s %15s %9s %14s %12s %16s %13s %19s %13s " , "#" , "VIN" , "Manufacturer" , "Color" , "Model" , "Max range" , "Safety Rating"  , "Price" , "Recharge time" , "Battery");
					System.out.println("");
					car.displayInventory();
					System.out.println();
						
					
				}
				
				
				else if(input.equals("TOLAZ"))
				{
					System.out.println("111111111111111111111111111\r\n" + 
							"1_________________________1\r\n" + 
							"1_________________________1\r\n" + 
							"1_______¶¶¶¶¶¶¶¶¶¶________1\r\n" + 
							"1_________¶¶¶¶¶¶__________1\r\n" + 
							"1_________¶¶¶¶¶¶__________1\r\n" + 
							"1_________¶¶¶¶¶¶__________1\r\n" + 
							"1_________¶¶¶¶¶¶__________1\r\n" + 
							"1_________¶¶¶¶¶¶__________1\r\n" + 
							"1_________¶¶¶¶¶¶__________1\r\n" + 
							"1_________¶¶¶¶¶¶__________1\r\n" + 
							"1_________¶¶¶¶¶¶__________1\r\n" + 
							"1_________¶¶¶¶¶¶__________1\r\n" + 
							"1_______¶¶¶¶¶¶¶¶¶¶________1\r\n" + 
							"1_________________________1\r\n" + 
							"1_________________________1\r\n" + 
							"1____¶¶¶¶¶_______¶¶¶¶¶____1\r\n" + 
							"1__¶¶¶¶¶¶¶¶¶___¶¶¶¶¶¶¶¶¶__1\r\n" + 
							"1_¶¶¶¶¶¶¶¶¶¶¶_¶¶¶¶¶¶¶¶¶¶¶_1\r\n" + 
							"1_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_1\r\n" + 
							"1__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶__1\r\n" + 
							"1____¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶____1\r\n" + 
							"1______¶¶¶¶¶¶¶¶¶¶¶¶¶______1\r\n" + 
							"1________¶¶¶¶¶¶¶¶¶________1\r\n" + 
							"1_________¶¶¶¶¶¶¶_________1\r\n" + 
							"1__________¶¶¶¶¶__________1\r\n" + 
							"1___________¶¶¶___________1\r\n" + 
							"1____________¶____________1\r\n" + 
							"1_________________________1\r\n" + 
							"1_________________________1\r\n" + 
							"1_¶¶¶¶¶¶¶¶¶_____¶¶¶¶¶¶¶¶¶_1\r\n" + 
							"1___¶¶¶¶¶_________¶¶¶¶¶___1\r\n" + 
							"1___¶¶¶¶¶_________¶¶¶¶¶___1\r\n" + 
							"1___¶¶¶¶¶_________¶¶¶¶¶___1\r\n" + 
							"1___¶¶¶¶¶_________¶¶¶¶¶___1\r\n" + 
							"1___¶¶¶¶¶_________¶¶¶¶¶___1\r\n" + 
							"1___¶¶¶¶¶_________¶¶¶¶¶___1\r\n" + 
							"1___¶¶¶¶¶_________¶¶¶¶¶___1\r\n" + 
							"1___¶¶¶¶¶¶_______¶¶¶¶¶¶___1\r\n" + 
							"1____¶¶¶¶¶¶_____¶¶¶¶¶¶____1\r\n" + 
							"1______¶¶¶¶¶¶¶¶¶¶¶¶¶______1\r\n" + 
							"1________¶¶¶¶¶¶¶¶¶________1\r\n" + 
							"1_________________________1\r\n" + 
							"111111111111111111111111111\r\n" + 
							"");
				}
				
				
				
				
				
				
				//Electric Cars only
				else if(input.equals("FEL"))
				{
					car.filterByElectric();
					System.out.println();
				}
				//AWD Cars only
				else if(input.equals("FAW"))
				{
					car.filterByAWD();
					System.out.println();
				}
				//Clear filters
				else if(input.equals("FCL"))
				{
					car.FiltersClear();
					System.out.println("");
				}
				//Filter by price range
				else if(input.equals("FPR"))
				{
					if (!scanner2.hasNextDouble()) 
					{
						System.out.println("");
						continue;
					}
					double min = scanner2.nextDouble();
					System.out.println("");
					//System.out.println(min);
					
					
					if(!scanner2.hasNextDouble())
					{
						System.out.println("");
						continue;
					}
					double max = scanner2.nextDouble();
					System.out.println("");
					//System.out.println(max);
					
					if(max>min)
					{
						car.fillterByPrice(min, max);
						System.out.println("");
					}
					else if(min > max || min==max)
					{
						System.out.println("min is greater than max");
						System.out.println("");
						continue;
					}
					
				}
				//Sort cars by price
				else if(input.equals("SPR"))
				{
					car.sortByPrice();
					System.out.println("");
				}
				//Sort cars by safety rating
				else if(input.equals("SSR"))
				{
					car.sortBySafetyRating();
					System.out.println("");
				}
				//Sort cars by max range
				else if(input.equals("SMR"))
				{
					car.sortByMaxRange();
					System.out.println("");
				}
				//2 car
				else if(input.equals("BUY"))
				{
					if(!scanner2.hasNextInt())
					{
						System.out.println("");
						continue;
					}
		
					int index = scanner2.nextInt();
				
					for(int x = 0 ; x < newCars.size() ; x++)
					{
						if(newCars.get(x).getVIN() == index)
						{
						
						SalesTeam salesTeam = new SalesTeam();
						String name = salesTeam.SalesName();
						
						//	
							
						//date
							
						int day = (int)(Math.random()*3) + 1;
						//Adding day
						calendar.add(calendar.DAY_OF_MONTH, +day);			
						String Cal = sdf2.format(calendar.getTime());
						Scanner scan = new Scanner(Cal);
						String taker = "";
						int month2;
						for(int y = 0 ; y < 2 ; y++)
						{
							taker = scan.next();
						}

						month2 = Integer.valueOf(taker);
						
						
						SoldCars.add(0, newCars.get(x));
						SoldCars.add(newCars.get(x));
						AccountingSystem2 accountingSystem = new AccountingSystem2( newCars.get(x)  , "BUY" , name , calendar , month2 );
						System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
						System.out.format("%-2s %6s %15s %9s %14s %12s %16s %13s %19s %13s " , "#" , "VIN" , "Manufacturer" , "Color" , "Model" , "Max range" , "Safety Rating"  , "Price" , "Recharge time" , "Battery");						
						System.out.println("");
						car.displaySoldCar(x);
						car.displayBought();
						System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

						car.buyCar(x);	

						}
						
					}
					System.out.println("");
					continue;
				}
				//Return car
				else if(input.equals("RET"))
				{
					if(SoldCars.get(0) == null)
					{
						System.out.println("There is nothing to return");
						System.out.println("");
						continue;
					}
					
					
					//sales name
					SalesTeam salesTeam = new SalesTeam();
					String name = salesTeam.SalesName();
				
					//	
					
					//date
					int day = (int)(Math.random()*3) + 1;
					//Adding day
					calendar.add(calendar.DAY_OF_MONTH, +day);
					
					calendar.add(calendar.DAY_OF_MONTH, +day);			
					String Cal = sdf2.format(calendar.getTime());
					Scanner scan = new Scanner(Cal);
					String taker = "";
					int month2;
					for(int y = 0 ; y < 2 ; y++)
					{
						taker = scan.next();
					}

					month2 = Integer.valueOf(taker);
				
					car.returnCar(SoldCars.get(0));
					Car car2 = SoldCars.get(0);
					AccountingSystem2 accountingSystem = new AccountingSystem2( car2  , "RET" , name , calendar , month2 );
					car.displayReturn();
					SoldCars.add(0 , null);
					System.out.println("");
				}
				
				
				
				
				
				
			//If user-inputed index out of range
			}	
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Invalid input ");
				System.out.println("");
			}//If user enters empty string	
			catch(NoSuchElementException b)
			{
				System.out.println("Invalid input");
				System.out.println("");
			}
			catch(IndexOutOfBoundsException e2)
			{
				System.out.println("");
			}
			
			catch(NullPointerException e3)
			{
				System.out.println("");
			}
			
		
		}
		
	}
}
