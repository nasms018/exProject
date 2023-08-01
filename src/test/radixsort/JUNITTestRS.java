package test.radixsort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import radixSorter.RS_Perfomance;
	//제대로 안됨 실패
class JUNITTestRS {

	@Test
	void test() {
		fail("Not yet implemented");
		long[] data = { 0, 1, -1 };

		long[] sorted = RS_Perfomance.rxSort(data);
		long prev = 0;
		for (int i = 0; i < 3; i++) {
			assertTrue(prev <= sorted[i]);
			prev = sorted[i];
		}
		assertTrue(prev == 1);

	}
}
