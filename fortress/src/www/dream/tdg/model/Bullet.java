package www.dream.tdg.model;

public class Bullet extends PhysicalEntity {
	// 탄환// 수평속도, 수직속도 m/sec
	/** 발사속도 : m /sec */
	private int 발사속도 = 33;
	private double horizontalSpeed = 0.0, verticalSpeed = 0.0;
	private PhysicalEntity target;

	public Bullet() {
		super(-1, -1);
	}

	public int get발사속도() {
		return 발사속도;
	}

	public void initVelocity(double 발사각도) {
		horizontalSpeed = 발사속도 * Math.cos(발사각도);
		verticalSpeed = 발사속도 * Math.sin(발사각도);
	}

	@Override //동적바인딩
	public void timeElapsed(float gravity, int timePeriod) { // timeElapsed:경과시간
		verticalSpeed += gravity * timePeriod / 1000;
		moveHorizontally(horizontalSpeed, timePeriod);
		moveVertically(verticalSpeed, timePeriod);
		boolean canMoveNext = moveVertically(verticalSpeed, timePeriod);
		System.out.println(this);
		if (!canMoveNext) {
			double distance = calcDistance(target);
			if (distance < 20) {
				System.out.println("A학점");
			} else if (distance < 50) {
				System.out.println("B학점");
			} else if (distance < 100) {
				System.out.println("C학점");
			} else {
				System.out.println("F학점");
			}
		}
	}

	public void setTarget(PhysicalEntity target) {
		this.target = target;
	}

}