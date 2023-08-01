package a.b.c;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	// 1~20사이의 정답만들기
	public static void main(String[] args) {
		Random rd = new Random();
		int answer = rd.nextInt(20) + 1; // 1~20
		// int answer = rd.nextInt(1, 21); //오류뜸 버전? 문제
		// double rn = Math.random(); // 0.000~1.000
		// int answer = (int) (rn * 20) + 1;
		Scanner input = new Scanner(System.in);

		int tryCount = 0; // 시도횟수

		do {
			System.out.print("정답을 추측하여 보시오 : "); // 입력장치
			int inputNum = input.nextInt(); // 사용자의 추측받기
			tryCount++; // 시도횟수 증가
			if (inputNum > answer) { // 정답비교
				System.out.println("입력값이 답보다 큽니다.");
			} else if (inputNum < answer) { // 정답비교
				System.out.println("입력값이 답보다 작습니다.");
			} else {
				break;// while (answer != inputNum); 면 if 포함필요 없음
			} // 못 맞추면 시도 횟수 올리고 추측 또 받기

		} while (true); // while (answer != inputNum); // 같으면 빠져나오기
		System.out.printf("축하합니다. 정답입니다. 시도횟수 = %d", tryCount);// 시도횟수 출력
		input.close();
	}

}
