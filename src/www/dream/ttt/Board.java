package www.dream.ttt;

import java.util.ArrayList;
import java.util.List;

public class Board {
	/* 상수 정의 : private static final */
	private static final int ROOT = 3;
	private Cell[][] cells = new Cell[ROOT][ROOT];
	private List<Line> listLine = new ArrayList<>(); // lines는 잘안씀 listLinelinesList

	/**
	 * 생성자. counstructor 생성시에 처리하여야 할 기능들을 작성하는 영역 칸과 줄을 만들고 둘사이의 관계 정보까지 설정한다.
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

	public static void main(String[] args) {
		Board tttBoard = new Board();
	}
}
