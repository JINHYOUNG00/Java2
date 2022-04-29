package co.micol.prj.game;

import java.util.Scanner;

public class Mabangjin {
	private Scanner scn = new Scanner(System.in);

	public void run() {
		mabangjin();
	}

	public void mabangjin() {
		System.out.println("마방진");
		System.out.print("3이상 홀수입력 >>>>");
		int size = scn.nextInt();
		if (size % 2 == 0) {
			System.out.println("홀수만 입력하세요");
		}
		int[][] arr = new int[size][size]; // 선언한 수의 사이즈만큼의 배열선언
		int num = 1;
		System.out.println(size + " * " + size + "마방진");

		for (int i = 0, j = size / 2; num < size * size; num++) {
			arr[i][j] = num;
			if (num % size == 0) {
				i++;
			} else {
				i--;
				j++;
				if (i < 0)
					i = size - 1;
				if (j > size - 1)
					j = 0;
			}

		}
		toPrint(arr);
	}
	private void toPrint(int[][] result) {
		for(int[] num: result) {
			for(int n: num) {
				System.out.printf("%3d",n);
			}
			System.out.println();
		}
	}
}
