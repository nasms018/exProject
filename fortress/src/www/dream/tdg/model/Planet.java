package www.dream.tdg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Planet {
	private static final int FRAME_COUNT = 30, TIME_PERIOD = 1000 / FRAME_COUNT;
	/** m/s 포탄이 하늘로 솓구칠때의 방향을 +로 잡을 것 */
	private float gravity; // 중력 가속도
	private List<PhysicalEntity> listPE = new ArrayList<>();

	// 싱글톤 패턴 private static Planet INSTANCE = new Planet();
	// 싱글톤 패턴 public static Planet getInstance() { return INSTANCE;}

	private static final Planet INSTANCE = new Planet(-9.8f);

	public static Planet getInstance() {
		return INSTANCE;
	}

	public Planet(float d) {
		this.gravity = d;
	}

	public void load(PhysicalEntity pe) {
		listPE.add(pe);
	}

	private Timer timer = new Timer();

	public void startSimulation() {
		TimerTask task = new TimerTask() {
			public void run() {
				for (PhysicalEntity pe : listPE) {
					pe.timeElapsed(gravity, TIME_PERIOD);
				}
			}
		};
		timer.schedule(task, 0, TIME_PERIOD); // (,출력시점,출력간격)
	}

	public void stopSimulation() {
		timer.cancel();
	}

	public int getCount(Class cls) {
		int count = 0;
		for (PhysicalEntity pe : listPE) {
			if (pe.getClass() == cls) {
				count++;
			}
		}
		return count;
	}

}