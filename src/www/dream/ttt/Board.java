package www.dream.ttt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
	/* 상수 정의 : private static final */
	private static final int ROOT = 3;
	private Cell[][] cells = new Cell[ROOT][ROOT];
	private List<Line> listLine = new ArrayList<>(); // lines는 잘안씀 listLinelinesList

	/**
	 * 생성자. counstructor 생성시에 처리하여야 할 기능들을 작성하는 영역 칸과 줄을 만들고 둘사이의 관계 정보까지 설정한다. 그리디
	 * 알고리즘으로
	 */
	public Board() {
		// Cell 반복적 만들기
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				cells[row][col] = new Cell();
			}
		}
		// 가로 Line 만들기
		for (int row = 0; row < ROOT; row++) {
			Line horizontalLine = new Line();
			for (int col = 0; col < ROOT; col++) {
				// --Line아. Cell받아라
				horizontalLine.칸담아라(cells[row][col]); // 칸담아라
			}
			listLine.add(horizontalLine);
		}
		// 세로 Line 만들기
		for (int col = 0; col < ROOT; col++) {
			Line verticalLine = new Line();
			for (int row = 0; row < ROOT; row++) {
				verticalLine.칸담아라(cells[row][col]); // 칸담아라
			}
			listLine.add(verticalLine);
		}
		// 정대각선만들기. 00, 11, 22
		Line diagonalLine = new Line();
		for (int idx = 0; idx < ROOT; idx++) {
			diagonalLine.칸담아라(cells[idx][idx]);
		}
		listLine.add(diagonalLine);

		// 역대각선 만들기 02, 11, 20 //revDiagonalLine
		Line revDiagonalLine = new Line();
		for (int idx = 0; idx < ROOT; idx++) {
			revDiagonalLine.칸담아라(cells[idx][ROOT - idx - 1]);
		}
		listLine.add(revDiagonalLine);

		// --Cell아. 너는 Line의 담겼단다.
	}

	/**
	 * 상황출력
	 */
	private void display() {
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				System.out.print(cells[row][col].돌그림줘());
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

	public Cell getEmptyCell(int row, int col) {
		if (row < 0 || row >= ROOT)
			return null;
		if (col < 0 || col >= ROOT)
			return null;
		if (cells[row][col].빈상태니())
			return cells[row][col];
		System.out.println("놓인 곳을 선택한 잘못");
		return null;
	}

	public static void main(String[] args) {
		Board tttBoard = new Board();
		Player user = new Player(StoneType.White);
		Player com = new Player(StoneType.Black);
		Scanner input = new Scanner(System.in);
		boolean isUserTurn = false; // 컴퓨터의 턴
		do {
			if (isUserTurn) {
				user.너마음에드는칸에돌놓아라(tttBoard);
			} else {
				tttBoard.getEmptyCell(1, 1).돌놓을게(StoneType.Black);
			}
			tttBoard.display();
			isUserTurn = !isUserTurn; // 참이면 거짓으로 거짓이면 참으로 반전시킴//턴넘기기
		} while (true);

	}

}
