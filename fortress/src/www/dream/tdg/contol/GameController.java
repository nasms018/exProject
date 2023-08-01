package www.dream.tdg.contol;



import www.dream.tdg.model.Bullet;
import www.dream.tdg.model.Cannon;
import www.dream.tdg.model.PhysicalEntity;
import www.dream.tdg.model.Planet;

public class GameController {

	public static void main(String[] args) {
		// 싱글톤으로인해 지움 Planet earth = new Planet(-9.8f); // 중력가속도 지정
		
		Cannon myK9 = new Cannon(0, 0); // 캐논은 좌하단 배치
		Bullet bullet = new Bullet();
		myK9.loadBullet(bullet); // 캐논에 탄환 충전

		PhysicalEntity target = new PhysicalEntity(100, 0);// 우하단배치

		Planet.getInstance().load(myK9);
		Planet.getInstance().load(target);
		Planet.getInstance().load(bullet);
		
		myK9.setShootAngle(target);
		myK9.shoot();

		Planet.getInstance().startSimulation();
	}
}