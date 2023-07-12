package www.dream.ttt;

import java.util.Scanner;

public class Player {
	private StoneType myStone;

	private Scanner scan = new Scanner(System.in);

	public Player(StoneType myStone) {
		this.myStone = myStone;
	}

	public void 너마음에드는칸에돌놓아라() {
		do {
			System.out.print("돌이 놓인 상황을 보고 빈칸을 선택하세요.");// 아웃에대한 의존관계
			int row = scan.nextInt(); // 의존관계 : 가장 보편적인 관계
			int col = scan.nextInt();
			Cell chosenCell = Board.getInstance().getEmptyCell(row, col);
			if (chosenCell != null) {
				chosenCell.돌놓을게(myStone);
				Board.getInstance().빈칸목록에서지워라(chosenCell);
				return;
			} else {

			}
		} while (true);
	}

	public void 해당칸에돌놓아라(Cell best) {
		best.돌놓을게(myStone);
		Board.getInstance().빈칸목록에서지워라(best);

	}
}
