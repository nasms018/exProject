package www.dream.tdg.model;

// 움직이는 객체, 물체
public class PhysicalEntity {
	/** meter체계 */
	private double positionX, positionY;

	public PhysicalEntity(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	protected void clonePosition(PhysicalEntity other) { // 장전효과
		other.positionX = this.positionX; // other에 this옮기고 0 0
		other.positionY = this.positionY;
	}

	/**
	 * 유클리드 거리 계산 (루트((적x-나x)^2+(적y-나y)^2))
	 * 
	 */
	public double calcDistance(PhysicalEntity other) {
		return Math.sqrt((other.positionX - this.positionX) * (other.positionX - this.positionX)
				+ (other.positionY - this.positionY) * (other.positionY - this.positionY));
	}

	public void timeElapsed(float gravity, int timePeriod) {

	}

	protected void moveHorizontally(double horizontalSpeed, int timePeriod) {
		positionX += horizontalSpeed * timePeriod / 1000;
	}

	protected boolean moveVertically(double verticalSpeed, int timePeriod) {
		positionY += verticalSpeed * timePeriod / 1000;
		if (positionY < 0) {
			// 포탄이 땅에 닿았음
			Planet.getInstance().stopSimulation();
			return false;
		}
		return true;
	}
	
	public String toString() { // 해당클래스 변수정보 출력
		return String.format("X=%.2f, Y=%.2f", positionX, positionY);
	}

}