package co.test;

public class Card {
	
	//필드
	protected String cardNo;
	protected String vaildDate;
	protected int cvc;
	//생성자
	public Card(String cardNo, String vaildDate, int cvc) {
		super();
		this.cardNo = cardNo;
		this.vaildDate = vaildDate;
		this.cvc = cvc;
	}
	

	//메소드
	public String getCardNo() {
		return cardNo;
	}
	public String getVaildDate() {
		return vaildDate;
	}
	public int getCvc() {
		return cvc;
	}
	
	public void showCardInfo() {
		System.out.println("카드정보 ( Card No : " + cardNo + ", 유효기간 : " + vaildDate + ", CVC : " + cvc + ")");
	}


	

}
