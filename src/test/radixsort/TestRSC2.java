package test.radixsort;

import radixSorter.RSC;
import radixSorter.RS_Perfomance;

public class TestRSC2 {
	public static void main(String[] args) {
		int data_size = 10000000; // 1천만번
		Long[] data = new Long[data_size];
		long[] lData = new long[data_size];
		for (int i = 0; i < data_size; i++) {
			data[i] = (long) (Math.random() * 100000000) - 50000000;
			lData[i] = data[i];
		}

		long startTimeMillis = System.currentTimeMillis();
		data = RSC.rxSort(data, 10);
		long dupTimeMillis = System.currentTimeMillis() - startTimeMillis;
		System.out.printf("걸린시간은 %d밀리초\t", dupTimeMillis);

		startTimeMillis = System.currentTimeMillis();
		lData = RS_Perfomance.rxSort(lData);
		dupTimeMillis = System.currentTimeMillis() - startTimeMillis;
		System.out.printf("걸린시간은 %d밀리초\t", dupTimeMillis);

		for (int i = 0; i < 10; i++) {
			System.out.print(lData[i] + " ");
		}
		System.out.println();

//		System.out.println();
//		Long[] ld = { 170L, 45L, 75L, 88L, 255L, 4L, 62L, 802L, 66L, 38L };
//		ld = RSC.rxSort(ld, 10);
//		for (Long v : ld)
//			System.out.print(v + " ");

	}
}
