package www.dream.ttt;

import java.util.List;
import java.util.Scanner;

public class Player {
	private StoneType myStone;
	private String name;

	private Scanner scan = new Scanner(System.in);

	public Player(String name, StoneType myStone) {
		this.name = name;
		this.myStone = myStone;
	}

	public void 너마음에드는칸에돌놓아라() {
		do {
			System.out.print("돌이 놓인 상황을 보고 빈칸을 선택하세요.");// 아웃에대한 의존관계
			int row = scan.nextInt(); // 의존관계 : 가장 보편적인 관계
			int col = scan.nextInt();
			Cell chosenCell = Board.getInstance().getEmptyCell(row, col);
			if (chosenCell != null) {
				해당칸에돌놓아라(chosenCell);
				return;
			} else {

			}
		} while (true);
	}

	public void 해당칸에돌놓아라(Cell best) {
		best.돌놓을게(myStone);
		Board.getInstance().빈칸목록에서지워라(best);
	}

	@Override
	public String toString() {
		return name;
	}

	public void playByAuto() {
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
		해당칸에돌놓아라(best);
		Board.getInstance().빈칸목록에서지워라(best);		
	}

}