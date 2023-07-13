package www.dream.ttt;

import java.util.Scanner;

public class UserPlayer extends Player {
	
	private Scanner scan = new Scanner(System.in);

	public UserPlayer(String name, StoneType myStone) {
		super(name, myStone);
	}
	@Override
	public void 너마음에드는칸에돌놓아라() { //유저의 기능
		do {
			System.out.print("돌이 놓인 상황을 보고 빈칸을 선택하세요.");// 아웃에대한 의존관계
			int row = scan.nextInt(); // 의존관계 : 가장 보편적인 관계
			int col = scan.nextInt();
			Cell chosenCell = Board.getInstance().getEmptyCell(row, col);
			if (chosenCell != null) {
				//this(나)의 상위 클래스 관점에서의 나입니다.
				chosenCell.돌놓을게(super.myStone);
				Board.getInstance().빈칸목록에서지워라(chosenCell);
				return;
			}
		} while (true);
	}
}
