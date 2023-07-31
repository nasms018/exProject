package www.dream.ttt;

import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

public class Board {
	/* 상수 정의 : private static final */
	private static final int ROOT = 3;
	private Cell[][] cells = new Cell[ROOT][ROOT]; // 구성(포함) 관계
	private List<Line> listLine = new ArrayList<>(); // 연관 관계 lines는 잘안씀 listLinelinesList
	private List<Cell> listEmptyCell = new ArrayList<>();

	private static final Board INSTANCE = new Board(); // 싱글톤 패턴

	public static Board getInstance() {
		return INSTANCE;
	}

	/**
	 * 생성자. counstructor 생성시에 처리하여야 할 기능들을 작성하는 영역 칸과 줄을 만들고 둘사이의 관계 정보까지 설정한다. 그리디
	 * 알고리즘으로
	 */
	public Board() {
		// Cell 반복적 만들기
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				cells[row][col] = new Cell();
				listEmptyCell.add(cells[row][col]);
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
	public void display() {
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				System.out.print(cells[row][col].돌줘().getDisplayChar());
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

	public List<Cell> getAllEmptyCell() {
		return listEmptyCell;
	}

	public void 빈칸목록에서지워라(Cell chosenCell) {
		listEmptyCell.remove(chosenCell);
	}

	public boolean 계속할까(Player curPlayer) {
		줄평가해();
		for (Line line : listLine) {
			if (line.다채워졌니()) {
				System.out.println(curPlayer + "님 승리를 축하");
				return false;
			}
		}

		if(listLine.size() == 0) {
			System.out.println("더 해도 승리 불가(무승부)");
			return false;
		} else {
			// 가치있는 줄이 있을때 계속할수 있다. 가치 있는 줄이 없는 상태면 계속할수 없다
			return true; // = !(listLine.isEmpty() == 0);
			
		}
	}

	private void 줄평가해() {
		List<Line> listUselessLine = new ArrayList<>(); // 가치없는 줄들
		// lambda 함수형 프로그램
		listLine.parallelStream().forEach(line -> {// 병렬스트림(흐름) //하나짜리는 스트림
			line.evaluate();
			if (line.getScore() == 0) {
				listUselessLine.add(line);
			}
		});
		listLine.removeAll(listUselessLine);
	}
}