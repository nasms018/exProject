package www.dream.array;

public class RandomWork {

	public static void main(String[] args) {
		final int ROOT = 5;
		boolean[][] visited = new boolean[ROOT][ROOT];
		int curRow = ROOT / 2, curCol = ROOT / 2;
		visited[curRow][curCol] = true;
		//방문 걸어간 경로 출력
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
