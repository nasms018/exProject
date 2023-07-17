package test.radixsort;

import radixSorter.RSC;

public class TestRSC {
	public static void main(String[] args) {

		Integer[] data = { 45, -1702, 75, -90, 2, -24, 802, 66};
		data = RSC.rxSort(data, 10);
		for (Integer v : data)
			System.out.print(v + " ");

//		System.out.println();
//		Long[] ld = { 170L, 45L, 75L, 88L, 255L, 4L, 62L, 802L, 66L, 38L };
//		ld = RSC.rxSort(ld, 10);
//		for (Long v : ld)
//			System.out.print(v + " ");

	}
}
