package co.test;

public class SimplePayment implements Payment {
	
	double simplePaymentRatio;
	
	
	public SimplePayment(double simplePaymentRatio) {
		super();
		this.simplePaymentRatio = simplePaymentRatio;
	}

	@Override
	public int online(int price) {
		double simpleOn = (int)((Payment.onPR + simplePaymentRatio) * 100) ;    //13.00
		return (price *(int)((100 - simpleOn)))/100; // 물건가격 10000 카드할인 0.08, 온라인 0.05     0.13 할인율에  
	}

	@Override
	public int offline(int price) {
		double simpleOff = (int)((Payment.offPR + simplePaymentRatio) * 100);
		return (price *(int)((100 - simpleOff)))/100;
	}

	@Override
	public void showInfo() {
		System.out.println("*** 간편결제 시 할인정보");
		System.out.println("온라인 결재시 총 할인율 : "+(Payment.onPR + simplePaymentRatio));
		System.out.println("오프라인 결재 시 총 할인율 : "+(Payment.offPR + simplePaymentRatio));
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
