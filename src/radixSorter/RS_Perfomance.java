package radixSorter;

import java.util.Arrays;

import www.dream.lib.ReferenceHelper;

public class RS_Perfomance {
	/**
	 * 8 16 32 64 : 최대 공약수 8
	 * 
	 * @data 사전식 비교 가능한 원소들의 배열(양수 정수 배열)
	 * @radix 16진수
	 */
	private static final byte MASK = 0b1111, MASK_LENGTH = 4;

	public static int[] rxSort(int[] data) {
		int dataSize = data.length;
		int[] sortResult = Arrays.copyOf(data, dataSize);
		// 16개의 방이 필요// 버킷별 요소갯수
		int[] dateSizePerBucket = new int[MASK + 1];
		byte[] bucketId = new byte[dataSize]; // 각 데이터별 버킷 번호
		// 마지막 처리 용도로 정의한다.
		int positiveCount = 0;
		//long[] copied = new long[MASK];
		for (int shiftCnt = 0; shiftCnt < Integer.SIZE; shiftCnt += MASK_LENGTH) {
			for (int i = 0; i <= MASK; i++) {
				dateSizePerBucket[i] = 0;
			}
			// 각 숫자의 현재 관심자리를 기준으로 방별 발생횟수를 센다
			for (int j = 0; j < dataSize; j++) {
				bucketId[j] = (byte) ((data[j] >> shiftCnt) & MASK);
				dateSizePerBucket[bucketId[j]]++;
			}
			for (int i = 1; i <= MASK; i++) {
				dateSizePerBucket[i] += dateSizePerBucket[i - 1];
				if (i == MASK / 2) {
					positiveCount = dateSizePerBucket[i];
				}
			}
			for (int j = dataSize - 1; j >= 0; j--) { // 뒤에서부터 시작
				sortResult[dateSizePerBucket[bucketId[j]] - 1] = data[j];
				dateSizePerBucket[bucketId[j]]--; // 해당 숫자 카운트를 1 감소
			}
			// 데이터 교환
			data = ReferenceHelper.swap(sortResult, sortResult = data);
		}
		//양수 넣기
		System.arraycopy(data, 0, sortResult, dataSize-positiveCount, positiveCount);
		//음수 넣기
		System.arraycopy(data, positiveCount, sortResult, 0, dataSize-positiveCount);
				
		
		return sortResult;
	}

	public static long[] rxSort(long[] data) {
		int dataSize = data.length;
		long[] sortResult = Arrays.copyOf(data, dataSize);
		// 16개의 방이 필요// 버킷별 요소갯수
		int[] dateSizePerBucket = new int[MASK + 1];
		byte[] bucketId = new byte[dataSize]; // 각 데이터별 버킷 번호
		// 마지막 처리 용도로 정의한다.
		int positiveCount = 0;
		//long[] copied = new long[MASK];
		for (int shiftCnt = 0; shiftCnt < Long.SIZE; shiftCnt += MASK_LENGTH) {
			for (int i = 0; i <= MASK; i++) {
				dateSizePerBucket[i] = 0;
			}
			// 각 숫자의 현재 관심자리를 기준으로 방별 발생횟수를 센다
			for (int j = 0; j < dataSize; j++) {
				bucketId[j] = (byte) ((data[j] >> shiftCnt) & MASK);
				dateSizePerBucket[bucketId[j]]++;
			}
			for (int i = 1; i <= MASK; i++) {
				dateSizePerBucket[i] += dateSizePerBucket[i - 1];
				if (i == MASK / 2) {
					positiveCount = dateSizePerBucket[i];
				}
			}
			for (int j = dataSize - 1; j >= 0; j--) { // 뒤에서부터 시작
				sortResult[dateSizePerBucket[bucketId[j]] - 1] = data[j];
				dateSizePerBucket[bucketId[j]]--; // 해당 숫자 카운트를 1 감소
			}
			// 데이터 교환
			data = ReferenceHelper.swap(sortResult, sortResult = data);
		}
		//양수 넣기
		System.arraycopy(data, 0, sortResult, dataSize-positiveCount, positiveCount);
		//음수 넣기
		System.arraycopy(data, positiveCount, sortResult, 0, dataSize-positiveCount);
				
		
		return sortResult;
	}


}
