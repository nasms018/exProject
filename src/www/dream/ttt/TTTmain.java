package www.dream.ttt;

import java.util.List;

public class TTTmain {

	public static void main(String[] args) {
		Player user = new Player("유저", StoneType.White);
		Player auto = new Player("컴퓨터", StoneType.Black);
		// Scanner input = new Scanner(System.in);
		Player curPlayer = auto; // 컴퓨터의 턴
		do {
			if (curPlayer == user) {
				user.너마음에드는칸에돌놓아라();
			} else {
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
				auto.해당칸에돌놓아라(best);
				Board.getInstance().빈칸목록에서지워라(best);

			}
			Board.getInstance().display();
			// 종료 조건은 빈칸없어서 무승부 또는 승자 나옴.
			if (!Board.getInstance().계속할까(curPlayer))
				break;

			if (curPlayer == user) {
				curPlayer = auto;
			} else {
				curPlayer = user;
			}

			// curPlayer = !curPlayer; 참이면 거짓으로 거짓이면 참으로 반전시킴//턴넘기기
		} while (true);

	}

}
