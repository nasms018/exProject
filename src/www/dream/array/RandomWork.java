package www.dream.array;

public class RandomWork {

	public static void main(String[] args) {
		final int ROOT = 7; //총 칸수
		boolean[][] visited = new boolean[ROOT][ROOT];
		int curRow = ROOT / 2, curCol = ROOT / 2;
		visited[curRow][curCol] = true;
		final int TOT_STEPS = ROOT * ROOT / 4; // 총걸음수
		int steps = 0;
		for (; steps <TOT_STEPS; steps++) {
			// 갈 방향 4종류로 임의 생성 북N0 동E1 남S2 서W3
			int direction = (int) (Math.random()*4); //랜덤 0~3까지 출력
			if ( curRow > 0 && direction == 0 ) {
				curRow--; //북
			} else if ( curCol <= ROOT -1 && direction == 1 ) {
				curCol++; //동
			} else if ( curRow <= ROOT -1 && direction == 2 ) {
				curRow++; //남
			} else if ( curCol > 0 && direction == 3 ) { //else로만 하면 중지안되고 서쪽으로 가는 경향이 생긴다
				curCol--; //서
			}
			visited[curRow][curCol] = true;
			displayBoard(visited);
		}
	}
	/**
	 * 방문 경로 출력
	 * 
	 * @param visited
	 */
	private static void displayBoard(boolean[][] visited) {
		for (boolean[] aRow : visited) {
			for (boolean v : aRow) {
				if (v) {
					System.out.print("# ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
}
