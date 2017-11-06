package FactoryOfFaith;

public abstract class Placer
{
	private int posx;
	private int posy;
	private String message;
	
	public int getPosx ()
	{
		return posx;
	}
	
	public void setPosx (int newPosx)
	{
		posx = newPosx;
	}
	
	public int getPosy ()
	{
		return posy;
	}
	
	public void setPosy (int newPosy)
	{
		posy = newPosy;
	}
	
	public String getMessage ()
	{
		return message;
	}
	
	public void setMessage(String newMessage)
	{
		message = newMessage;
	}
}
