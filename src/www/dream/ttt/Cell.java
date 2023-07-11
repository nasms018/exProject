package www.dream.ttt;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private List<Line> listLine = new ArrayList<>(); //listLine:너가 담긴 라인목록
	private StoneType depositedStone = StoneType.Empty; //놓인 돌
	
	public void 너는이라인에담겨있다기억해라(Line line) {
		listLine.add(line); //너가 담긴 라인목록에 라인을 담는다.
	}
	public char 돌그림줘() {
		return depositedStone.getDisplayChar();
	}

}
