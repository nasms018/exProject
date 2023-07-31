package www.dream.tdg.model;

import java.util.Scanner;

public class Cannon extends PhysicalEntity {
	/** 각도 : 단위 5~ 85도 */
	private static final int MIN_ANGLE = 5, MAX_ANGLE = 85;
	// private static final int MAX_ANGLE = 85;
	private double 발사각도;
	private Bullet bullet = null;

	public Cannon(int i, int j) {
		super(i, j);
	}

	public void loadBullet(Bullet bullet) {
		clonePosition(bullet);
		this.bullet = bullet; // -1 -1을 0 0으로 옮기고
	}

	/**
	 * 포수로부터 각도를 입력받는다
	 */
	public void setShootAngle(PhysicalEntity target) {
		Scanner scan = new Scanner(System.in);
		double distance = calcDistance(target); // 거리계산
		int 발사각도;
		do {
			System.out.printf("적과의 거리는 %.2f미터입니다.\n포탄속도는 %d입니다. \n발사각도를 입력하여 발사하세요\n", distance, bullet.get발사속도());
			System.out.printf("발사각도는 %d도와 %d도 사이입니다. 발사각도 : ", MIN_ANGLE, MAX_ANGLE);
			발사각도 = scan.nextInt();
		} while (발사각도 < MIN_ANGLE || 발사각도 > MAX_ANGLE);
		this.발사각도 = Math.toRadians(발사각도);
		bullet.setTarget(target);
		scan.close();
	}

	public void shoot() {
		bullet.initVelocity(발사각도);
	}
}