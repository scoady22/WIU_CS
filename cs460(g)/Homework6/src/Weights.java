public class Weights
{
	private static double w1;
	private static double w2;

	public Weights()
	{
		double w1;
		double w2;
	
	}
	
	public void setW(double w,double w2)
	{
		this.w1=w;
		this.w2 = w2;
		
	}
	
	public static double getW1()
	{
		return w1;
	}
	
	public static double getW2()
	{
		return w2;
		
	}
	
	public String toString()
	{
		
		return w1+" "+w2;
		
	}

}