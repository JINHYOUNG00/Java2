package co.micol.prj.game;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Lotto {

	private int money;
	private Random random;
	private Scanner scn = new Scanner(System.in);
	TreeSet<Integer> luckeyNum = new TreeSet<>();
	TreeSet<Integer> gameNum = new TreeSet<>();

	public void run() {
		System.out.println("################로또게임################");
		title();
	}

	private void title() {
		System.out.println("로또게임을 시작합니다");
		lotto();
	}

	private void lotto() {
		while (luckeyNum.size() < 6) {
			luckeyNum.add((int) ((Math.random() * 45) + 1));
		}
		while (gameNum.size() < 6) {
			System.out.println("1~45까지 중복되지않는 숫자 6자를 입력하세요");
			int input = scn.nextInt();
			gameNum.add(input);
			scn.nextLine();
		}

		System.out.println(luckeyNum.toString());
		System.out.println(gameNum.toString());
		luckeyNum.clear();
		gameNum.clear();
	}

}
