
public class ElectricCar extends Car {
	
	//Instance variables
	private int rechargeTime; 
	private String batteryType;
	
	/** ElectricCar constructor method
	 * 	@param mfr1				The manufacturer of the car
	 * 	@param color1			The color of the car
	 * 	@param model2			The model of the car
	 * 	@param power1			The power source of the car
	 * 	@param safetyRating1	The safety rating of the car
	 *  @param maxRange1		The max range of the car
	 *  @param AWD1				If the car is AWD
	 *  @param price1			The price of the car
	 *  @param rechargeTime1	The recharge time of the car
	 *  @param batteryType1		The battery type of the car
	 * */
	public ElectricCar(int vin , String mfr1, String color1,  model model2, power power1  , double safetyRating1 , 
			int maxRange1  ,  boolean AWD1 ,  double price1 , int rechargeTime1 , String batteryType1) 
	
	{
		super(vin , mfr1, color1, model2, power1, safetyRating1 , maxRange1 , AWD1, price1); 
		rechargeTime = rechargeTime1;
		batteryType = batteryType1;
	}
	/** ElectricCar constructor method without the recharge time or battery type
	 * 
	 * @param mfr1				The manufacturer of the car
	 * @param color1			The color of the car
	 * @param model2			The model of the car
	 * @param power1			The power source of the car
	 * @param safetyRating1		The safety rating of the car
	 * @param maxRange1			The max range of the car
	 * @param AWD1				If the car is AWD
	 * @param price1			The price of the car
	 */
	public ElectricCar(int vin , String mfr1, String color1,  model model2, power power1  , double safetyRating1 , 
			int maxRange1  ,  boolean AWD1 ,  double price1)
	{
		super(vin , mfr1, color1, model2, power1, safetyRating1 , maxRange1 , AWD1, price1);
	}
	
	/** getRechargeTime method
	 * 
	 * @return recharge time
	 */
	public int getRechargeTime()
	{
		return rechargeTime;
	}
	
	/** getBatteryType method
	 * 
	 * @return battery type
	 */
	public String getBatteryType()
	{
		return batteryType;
	}
	/** display method that overrides from super class
	 * 	@return car and its attributes
	 */
	public String display()
	{
		String timeSpace = "                    ";
		String timeLength = String.valueOf(rechargeTime);
		String Space = "";
		for(int x = 0 ; x < timeSpace.length() - timeLength.length() ; x++)
		{
			Space = Space + " ";
		}
		
		String battrySpace = "              ";
		String Space1 = "";
		for(int x = 0 ; x < battrySpace.length() - batteryType.length() ; x++)
		{
			Space1 = Space1 + " ";
		}
		return super.display() + Space + rechargeTime + Space1 + batteryType;
	}
	/** getTime method 
	 * 
	 * @return rechargeTime
	 * 
	 */
	public int getTime()
	{
		return rechargeTime;
	}
	
	
	
}
