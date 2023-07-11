package www.dream.ttt;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<Cell> listCell = new ArrayList<>();
	
	public void 칸담아라(Cell cell) { //칸담아라
		listCell.add(cell);
		cell.너는이라인에담겨있다기억해라(this); //너는이라인에담겨있다기억해라
	}

}
