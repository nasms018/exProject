package www.dream.ttt.model.domain;

public enum StoneType {
	Empty('.'), White('O'), Black('X');

	private char displayChar;

	private StoneType(char displayChar) {
		this.displayChar = displayChar;
	}

	public char getDisplayChar() {
		return displayChar;
	}

}
