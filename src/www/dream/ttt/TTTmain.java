package www.dream.ttt;

public class TTTmain {

	public static void main(String[] args) {
		final int PLAYER_CNT = 2;
		Player[] players = new Player[PLAYER_CNT];
		players[1] = new Player("컴퓨터", StoneType.Black);
		players[0] = new UserPlayer("유저", StoneType.White);

		int curPlayer = 0;
		do {
			players[curPlayer].너마음에드는칸에돌놓아라();
			Board.getInstance().display();
			// 종료 조건은 빈칸없어서 무승부 또는 승자 나옴.
			if (!Board.getInstance().계속할까(players[curPlayer]))
				break;
			curPlayer = ++curPlayer % PLAYER_CNT;

		} while (true);
	}
}
