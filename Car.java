
public class Car extends Vehicle implements Comparable<Car>{

	//Instance Variables
	private int maxRange , VIN;
	private double safetyRating , price;
	private boolean AWD;
	
	//Car enum for the model variable
	model Car;
	enum model
	{
		SEDAN("SEDAN"),
		SUV("SUV"),
		SPORTS("SPORTS"),
		MINIVAN("MINIVAN");
		
		private final String model1;
		
		private model(String model2)
		{
			this.model1 = model2;
		}
		
		public String getString()
		{
			return model1;
		}

		public boolean contentEquals(model car) 
		{
			// TODO Auto-generated method stub
			return false;
		}
	}
	/** Car constructor method
	 * 
	 * @param mfr1					The manufacturer of the car
	 * @param color1				The color of the car
	 * @param model2				The model of the car
	 * @param power1				The power source of the car
	 * @param safetyRating1			The safety rating of the car
	 * @param maxRange1				The max range of the car
	 * @param AWD1					If the car is AWD
	 * @param price1				The price of the car
	 */
	public Car(int vin , String mfr1, String color1,  model model2, power power1  , double safetyRating1 , 
			int maxRange1  ,  boolean AWD1 ,  double price1) 
	{	
		super(vin , mfr1, color1, power1);
		this.Car = model2;
		AWD = AWD1;
		safetyRating = safetyRating1;
		price = price1;
		maxRange = maxRange1;
		VIN = vin;
	}
	
	//@overrides    from Vehicle class
	public String display()
	{
		String modelSpace = "               ";
		String Space = "";
		for(int x = 0 ; x < modelSpace.length() - this.Car.getString().length() ; x++)
		{
			Space = Space + " ";
		}
		
		String maxRangeSpace = "             ";
		String Space1 = "";
		String rangeLength = String.valueOf(maxRange);
		for(int x = 0 ; x < maxRangeSpace.length() - rangeLength.length() ; x++)
		{
			Space1 = Space1 + " ";
		}
		
		String ratingSpace = "                 ";
		String Space2 = "";
		String ratingLength = String.valueOf(safetyRating);
		for(int x = 0 ; x < ratingSpace.length() - ratingLength.length() ; x++)
		{
			Space2 = Space2 + " ";
		}
		  /**
		String AWDSpace  = "          ";
		String Space3 = "";
		String AWDLength = String.valueOf(AWD);
		for(int x = 0 ; x < AWDSpace.length() - AWDLength.length() ; x++)
		{
			Space3 = Space3 + " ";
		}
		**/
		String priceSpace = "              ";
		String Space4  = "";
		String priceLength = String.valueOf(price);
		for(int x = 0 ; x < priceSpace.length() - priceLength.length() ; x++)
		{
			Space4 = Space4 + " ";
		}
		/**
		String NASpace = "                    ";
		String Space5 = "";
		String NA = "N/A";
		for(int x = 0 ; x < NASpace.length() - NA.length() ; x++)
		{
			Space5 = Space5 + " ";
		}**/
		return super.display() + Space + this.Car.getString() + Space1 + maxRange + Space2 + safetyRating + Space4 + price  ;
	}
	
	/** equals method to check for equality between two Car objects
	 * 
	 * @param other		The other Car object
	 * @return			True or false depending on equality
	 */
	public boolean equals(Car other)
	{
		if(super.equals(other))
		{
			if(this.Car.contentEquals(other.Car) && this.AWD == other.AWD)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
	}
	
	/** compareTo method to compare price between two Car objects
	 * 	@param other	The other Car object
	 * 	@return 1 		if the price of this car is greater than the price of the other car
	 * 	@return 0		if the price of this car is equal to the price of the other car
	 * 	@return -1		if the price of this car is less than the price of the other car
	 */
	public int compareTo(Car other)
	{
		if(this.price > other.price)
		{
			return 1;
		}
		if(this.price < other.price)
		{
			return -1;
		}
		return 0;
	}
	/** getAWD method
	 * 
	 * @return AWD
	 */
	public boolean getAWD()
	{
		return this.AWD;
	}
	/** getPrice method
	 * 
	 * @return price
	 */
	public double getPrice()
	{
		return this.price;
	}
	/** getSafetyRating method
	 * 
	 * @return safetyRating
	 */
	public double getSafetyRating()
	{
		return this.safetyRating;
	}
	/** getMaxRange method
	 * 
	 * @return maxRange
	 */
	public double getMaxRange()
	{		
		return this.maxRange;
	}
	
	public int getVIN()
	{
		return this.VIN;
	}


}
