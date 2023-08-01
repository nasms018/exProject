package test.radixsort;

import radixSorter.RSC;
import radixSorter.RSC_Perfomance;

public class TestRSC {
	public static void main(String[] args) {
		int max =10000000; //1천만번
		Integer[] data = new Integer[max];
		for (int i = 0; i < max; i++) {
			data[i] = (int) (Math.random() * 100000000) - 50000000;
		}
		long startTimeMillis = System.currentTimeMillis();
		data = RSC.rxSort(data, 10);
		long dupTimeMillis = System.currentTimeMillis() - startTimeMillis;
		System.out.println("걸린시간은" + dupTimeMillis );
		
		startTimeMillis = System.currentTimeMillis();
		//data = RSC_Perfomance.rxSort(data, 10);
		dupTimeMillis = System.currentTimeMillis() - startTimeMillis;
		System.out.println("걸린시간은" + dupTimeMillis );
		
		
		for (int i = 0; i < 10; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
		
//		System.out.println();
//		Long[] ld = { 170L, 45L, 75L, 88L, 255L, 4L, 62L, 802L, 66L, 38L };
//		ld = RSC.rxSort(ld, 10);
//		for (Long v : ld)
//			System.out.print(v + " ");

	}
}
