package com.roytuts.java.largest.product.array.without.sort;

public class JavaLargestProductInArrayWithoutSort {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 3, 6, 7, 0 };

		System.out.println(largestProductInArrayWithoutSort(arr));
	}

	public static int largestProductInArrayWithoutSort(int[] arr) {
		int len = arr.length;

		if (len < 2) {
			throw new RuntimeException("Insufficient elements in array");
		}

		int a = arr[0], b = arr[1];

		int p = 1;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] * arr[j] > a * b) {
					a = arr[i];
					b = arr[j];
					p = a * b;
				}
			}
		}

		return p;
	}
}
