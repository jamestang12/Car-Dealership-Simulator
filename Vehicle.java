
public class Vehicle {
	
	//Instance variables
	private String mfr, color;
	private int numWheels = 4;
	private int VIN;
	/**
	public static enum Crap {
		GAY, SHIT, ASS
	}
	
	enum Power {
		ELECTRIC_MOTOR("fuck"), GAS_ENGINE("gay");
		
		String s;
		
		private Power(String s) {
			this.s = s;
		}
		
		public String getPower()
		{
		return Power;
		}			
	
	Power p = Power.ELECTRIC_MOTOR;
			
	
	private void doShit(Power power) {
		if (power == Power.ELECTRIC_MOTOR) {
			// do something
		}
	}
	**/	
	/**  A power enum for the power source of the car
	 * 
	 */
	power Vehicle;
	public enum power
	{
		ELECTRIC_MOTOR(0),
		GAS_ENGINE(1);
		
		private final int power1;
		
		private power(int power2)
		{
			this.power1 = power2;
		}
		
		public int getPowerInt()
		{
			return power1;
		}
	}
	
	/** Vehicle constructor method
	 * @param VIN		The VIN of the car
	 * @param mfr1		The manufacturer of the car
	 * @param color1	The color of the car
	 * @param power1	The power source of the car
	 */
	public Vehicle(int vin , String mfr1 , String color1 , power power1 )
	{
		VIN = vin;
		mfr = mfr1;
		color = color1;
		this.Vehicle = power1;
	}

	/** equals method to check for equality between cars
	 * 
	 * @param other		The other car
	 * @return			True or false depending on equality
	 */
	public boolean equals(Vehicle other)
	{
		if(this.mfr.contentEquals(other.mfr) && this.getPower() == other.getPower() 
				&& this.numWheels == other.numWheels)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/** display method that displays the car and its attributes
	 * 
	 * @return car and its attributes
	 */
	public String display()
	{
		String VINspace = "     ";
		String Space2 = "";
		String VINlenght = String.valueOf(VIN);
		for(int x = 0 ; x < VINspace.length() - VINlenght.length() ; x++)
		{
			Space2 = Space2 + " ";
		}
		
		String mfrSpace = "                ";
		String Space = "";
		for(int x = 0 ; x < mfrSpace.length() - mfr.length() ; x++)
		{
			Space = Space + " ";
		}
		
		String colorSpace = "          ";
		String Space1 = "";
		for(int x = 0 ; x < colorSpace.length() - color.length() ; x++)
		{
			Space1 = Space1 + " ";
		}
		return  Space2 + VIN + Space +  mfr  + Space1 + color ;
	}
	
	/** getPower method
	 * 
	 * @return	powersource of the car
	 */
	public int getPower()
	{
		return Vehicle.getPowerInt();
	}
	
	/** getName method
	 * 
	 * @return manufacturer name
	 */
	public String getName()
	{
		return mfr;
	}
	
	
	
}
 