package www.dream.ttt;

import java.util.List;

public class TTTmain {

	public static void main(String[] args) {
		Player user = new Player(StoneType.White);
		Player auto = new Player(StoneType.Black);
		// Scanner input = new Scanner(System.in);
		boolean isUserTurn = false; // 컴퓨터의 턴
		do {
			if (isUserTurn) {
				user.너마음에드는칸에돌놓아라();
				Board.getInstance().줄평가해();
			} else {
				List<Cell> listEmptyCell = Board.getInstance().getAllEmptyCell();
				Cell best = listEmptyCell.get(0);
				int bestScore = best.getScore();
				for (int i = 1; i < listEmptyCell.size(); i++) {
					Cell empty = listEmptyCell.get(i);
					int score = empty.getScore();
					if( score > bestScore) {
						best = empty;
						bestScore = score;
					}
				}
				//best.돌놓을게(StoneType.Black);
				auto.해당칸에돌놓아라(best);
				Board.getInstance().빈칸목록에서지워라(best);
			}
			Board.getInstance().display();
			//종료 조건은 빈칸없어서 무승부 또는 승자 나옴.
			
			isUserTurn = !isUserTurn; // 참이면 거짓으로 거짓이면 참으로 반전시킴//턴넘기기
		} while (true);

	}

}
