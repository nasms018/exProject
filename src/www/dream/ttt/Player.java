package www.dream.ttt;

import java.util.List;

public class Player {
	private String name;
	protected StoneType myStone;

	public Player(String name, StoneType myStone) {
		this.name = name;
		this.myStone = myStone;
	}

	public void 너마음에드는칸에돌놓아라() { // 오토플레이어 기능
		List<Cell> listEmptyCell = Board.getInstance().getAllEmptyCell();
		Cell best = listEmptyCell.get(0);
		int bestScore = best.getScore();
		for (int i = 1; i < listEmptyCell.size(); i++) {
			Cell empty = listEmptyCell.get(i);
			int score = empty.getScore();
			if (score > bestScore) {
				best = empty;
				bestScore = score;
			}
		}
		// best.돌놓을게(StoneType.Black);
		best.돌놓을게(myStone);
		Board.getInstance().빈칸목록에서지워라(best);
	}

	@Override
	public String toString() {
		return name;
	}

}
