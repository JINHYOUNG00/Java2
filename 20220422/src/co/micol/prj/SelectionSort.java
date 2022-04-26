package co.micol.prj;

// 선택정렬
public class SelectionSort {
	// 멤버변수	
	private int i;
	private int j;
	private int min;
	private int max;
	
	
	public void sort(int[] arr) {
		// 초기데이터 출력
		
		arrPrint(arr);
		
		for(i = 0; i < arr.length-1; i++) {
			
			// 내림 차순
			max = i;
			for(j = i + 1; j < arr.length ; j++) { // 요소 비교
				if(arr[max] < arr[j]) {
					max = j;
				} 
			}
			
			
			if(max != i) {
				int temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
			}
					
			
			/*오름차순
			min = i;
			for(j = i + 1; j < arr.length ; j++) { // 요소 비교
				if(arr[min] > arr[j]) {
					min = j;
				} 
			}
			// 자리 변경이 생긴 경우 swap
			
			if(min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}*/
			
		}
		resultPrint(arr);
	}
	
	private void resultPrint(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("결과 데이터");
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}	


	private void arrPrint(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("초기 데이터");
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}	
}