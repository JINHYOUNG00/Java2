package co.test;

public interface Payment {
	
	
	public static final double onPR = 0.05;
	public static final double offPR = 0.03;
	
	
	
	public int online(int price);
		
	
	public int offline(int price);
		
	
	public void showInfo();
	
	

}
