package www.dream.ttt.model;

import java.util.ArrayList;
import java.util.List;

import www.dream.ttt.model.domain.StoneType;

public class Cell {
	private List<Line> listLine = new ArrayList<>(); // listLine:너가 담긴 라인목록
	private StoneType depositedStone = StoneType.Empty; // 놓인 돌

	public void 너는이라인에담겨있다기억해라(Line line) {
		listLine.add(line); // 너가 담긴 라인목록에 라인을 담는다.
	}

	public StoneType 돌줘() {
		return depositedStone;
	}

	public void 돌놓을게(StoneType myStone) {
		depositedStone = myStone;
	}

	public boolean 빈상태니() {
		return depositedStone == StoneType.Empty;
	}

	public int getScore() {
		int totScore = 0;
		for (Line line : listLine) {
			totScore += line.getScore();
		}
		return totScore;
	}

}
