package www.dream.ttt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Line {
	private List<Cell> listCell = new ArrayList<>();
	private int score = 1;

	public void 칸담아라(Cell cell) { // 칸담아라
		listCell.add(cell);
		cell.너는이라인에담겨있다기억해라(this); // 너는이라인에담겨있다기억해라
	}

	/**
	 * 블랙(오토)의 관점에서의 점수 ... : 1점 X.., .X., ..X : 5점 O.., .O., ..O : 3점 XO., X.O,
	 * OX., .XO, O.X, .OX : 0점 OO., .OO, O.O : 80점 XX., .XX, X.X : 100점
	 */
	public void evaluate() {
		int[] stoneStatus = new int[StoneType.values().length];
		// StoneType.Black.ordinal();
		// for (StoneType st : StoneType.values()) {
		// Autoboxing에 의해 자동 변환되어 담김.
		// stoneStatus++
		// stoneStatus.put(st, 0);
		// }

		for (Cell cell : listCell) {
			stoneStatus[cell.돌줘().ordinal()]++;
			// stoneStatus.put(cell.돌줘(), stoneStatus.get(cell.돌줘()) + 1);
		}
		if (stoneStatus[StoneType.Empty.ordinal()] == 3) {
			score = 1;
		} else if (stoneStatus[StoneType.Empty.ordinal()] == 2 && stoneStatus[StoneType.Black.ordinal()] == 1) {
			score = 5;
		} else if (stoneStatus[StoneType.Empty.ordinal()] == 2 && stoneStatus[StoneType.White.ordinal()] == 1) {
			score = 3;
		} else if (stoneStatus[StoneType.Empty.ordinal()] == 1 && stoneStatus[StoneType.Black.ordinal()] == 2) {
			score = 100;
		} else if (stoneStatus[StoneType.Empty.ordinal()] == 1 && stoneStatus[StoneType.White.ordinal()] == 2) {
			score = 80;
		} else {
			score = 0;
		}
	}

	public int getScore() {
		return score;
	}

}
