package www.dream.ttt;

import java.util.Scanner;

public class Player {
	private StoneType myStone;

	private Scanner scan = new Scanner(System.in);

	public Player(StoneType myStone) {
		this.myStone = myStone;
	}

	public void 너마음에드는칸에돌놓아라(Board tttBoard) {
		do {
			System.out.print("돌이 놓인 상황을 보고 빈칸을 선택하세요.");
			int row = scan.nextInt();
			int col = scan.nextInt();
			Cell chosenCell = tttBoard.getEmptyCell(row, col);
			if (chosenCell != null) {
				chosenCell.돌놓을게(myStone);
				return;
			} else {

			}
		} while (true);
	}
}
