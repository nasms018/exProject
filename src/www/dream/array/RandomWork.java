package www.dream.array;

public class RandomWork {

	public static void main(String[] args) {
		final int ROOT = 5;
		boolean[][] visited = new boolean[ROOT][ROOT];
		int curRow = ROOT / 2, curCol = ROOT / 2;
		visited[curRow][curCol] = true;
		displayBoard(visited);
	}

	/**
	 * 방문 경로 출력
	 * @param visited
	 */
	private static void displayBoard(boolean[][] visited) {
		for(boolean[] aRow: visited) {
			for(boolean v:  aRow) {
				if(v) {
					System.out.print("# ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
}
