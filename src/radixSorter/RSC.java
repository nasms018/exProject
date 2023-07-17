package radixSorter;

import java.util.Arrays;
import www.dream.lib.ArrayHelper;
import www.dream.lib.ReferenceHelper;
import www.dream.lib.data.Pair;
import www.dream.lib.discrete.MathHelper;

public class RSC {
	/**
	 * @data 사전식 비교 가능한 원소들의 배열(양수 정수 배열)
	 * @radix 기수
	 */

	public static <T extends Comparable<T>> T[] rxSort(T[] data, int radix) {
		Pair<T, T> minMaxPair = ArrayHelper.findMinMax(data);
		// 숫자의 최대 자리수
		int maxDigit = MathHelper.maxDigists(minMaxPair.getSecondVal(), radix); // 3
		int dataSize = data.length;

		int[] buketSize = new int[radix]; // 특정 자리에서 숫자들의 카운트

		// Cannot create a generic array of T T[] sortResult = new T[dataSize];
		// 해당 자릿수로 정렬한 결과
		T[] sortResult = Arrays.copyOf(data, dataSize); // 값을 복사해주세요

		int i, j, n;
		int curDigit; // 현재 관심있는 자릿수
		int[] bucketId = new int[dataSize]; // 각 데이터별 방 번호
		// 메모리 할당

		for (n = 0; n < maxDigit; n++) { // 1의 자리, 10의자리, 100의 자리 순으로 진행
			for (i = 0; i < radix; i++)
				buketSize[i] = 0; // 초기화
			// 위치값 계산.
			// n:0 => 1, 1 => 10, 2 => 100

			curDigit = (int) Math.pow(radix, n);
			// 각 숫자의 현재 관심자리를 기준으로 방별 발생횟수를 센다
			for (j = 0; j < dataSize; j++) {
				// 253이라는 숫자라면
				// n:0 => 3, 1 => 5, 2 => 2
				if (data[j] instanceof Integer)
					bucketId[j] = (int) ((int) data[j] / curDigit) % radix;
				if (data[j] instanceof Long)
					bucketId[j] = (int) ((long) data[j] / curDigit) % radix;
				buketSize[bucketId[j]]++;
			}
			// 카운트 누적합을 구한다. 계수정렬을 위해서.
			for (i = 1; i < radix; i++) {
				buketSize[i] += buketSize[i - 1];
			}
			// 카운트를 사용해 각 항목의 위치를 결정한다.
			// 계수정렬 방식
			for (j = dataSize - 1; j >= 0; j--) { // 뒤에서부터 시작
				sortResult[buketSize[bucketId[j]] - 1] = data[j];
				buketSize[bucketId[j]] = buketSize[bucketId[j]] - 1; // 해당 숫자 카운트를 1 감소
			}
			// 데이터 교환
			data = ReferenceHelper.swap(sortResult, sortResult = data);
			// tempRef = data;
			// data = temp;
			// temp = tempRef;
		}
		return data;
	}// 적용안됨
}
