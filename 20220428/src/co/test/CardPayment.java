package co.test;

public class CardPayment implements Payment {
	double cardRatio;

	public CardPayment(double cardRatio) {
		super();
		this.cardRatio = cardRatio;
	}
	

	@Override
	// 카드 할인율 0.08 입력, 온라인 0.05
	public int online(int price) {
		double cradOn = (int)((Payment.onPR + cardRatio) * 100) ;    //13.00
		return (price *(int)((100 - cradOn)))/100; // 물건가격 10000 카드할인 0.08, 온라인 0.05     0.13 할인율에  
	}

	@Override
	// 카드 할인율 0.05 입력, 오프라인 0.03
	public int offline(int price) {
		double cradOff = (int)((Payment.offPR + cardRatio) * 100);
		return (price *(int)((100 - cradOff)))/100;
	}
	
	@Override
	public void showInfo() {
		System.out.println("*** 카드로 결제 시 할인정보");
		System.out.println("온라인 결재시 총 할인율 : " + (Payment.onPR + cardRatio));
		System.out.println("오프라인 결재 시 총 할인율 : " + (Payment.offPR + cardRatio));
	}

}
