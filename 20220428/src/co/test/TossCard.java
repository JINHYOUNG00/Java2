package co.test;

public class TossCard extends Card  {

	
	private String company = "Toss";
	private String cardStaff;
	

	public TossCard(String cardNo, String vaildDate, int cvc, String cardStaff) {
		super(cardNo, vaildDate, cvc);
		this.cardStaff = cardStaff;
	}

	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card No, " + cardNo);
		System.out.println("담당직원 - " + cardStaff +", " + company);
	}
}
