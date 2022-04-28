package co.test;

public class DGBCard extends Card {

	private String company = "대구은행";
	private String cardStaff;
	
	
	
	
	
	
	
	public DGBCard(String cardNo, String vaildDate, int cvc, String cardStaff) {
		super(cardNo, vaildDate, cvc);
		this.cardStaff = cardStaff;
	}

	@Override
	public void showCardInfo() {
		System.out.println("카드정보 (Card No : " + cardNo + ", 유효기간 : " + vaildDate +", CVC : " + cvc + " )");
		System.out.println("담당직원 - " + cardStaff +", " + company);
	}
	
	
	
	

}
