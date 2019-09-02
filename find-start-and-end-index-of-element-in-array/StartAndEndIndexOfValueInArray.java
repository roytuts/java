public class StartAndEndIndexOfValueInArray {
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1, 2, 2, 3, 3, 3, 3, 3, 5, 8, 6, 9 };
		StartAndEndIndexOfValueInArray findIdx = new StartAndEndIndexOfValueInArray();
		int totalElements = arr.length;
		int startIndex = findIdx.findStartIndex(arr, 0, totalElements, 3);
		int endIndex = findIdx.findEndIndex(arr, 0, totalElements, 3, totalElements);
		System.out.println("Start Index: " + startIndex + ", End Index: " + endIndex);
	}
		   
	private int findStartIndex(int[] arr, int low, int high, int x) {
		if (high > low) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || x > arr[mid - 1]) && x == arr[mid]) {
				return mid;
			} else if (x > arr[mid]) {
				return findStartIndex(arr, mid + 1, high, x);
			} else {
				return findStartIndex(arr, low, mid - 1, x);
			}
		}
		return -1;
	}
		   
	private int findEndIndex(int[] arr, int low, int high, int x, int totalElements) {
		if (high > low) {
			int mid = low + (high - low) / 2;
			if ((mid == totalElements - 1 || x < arr[mid + 1]) && x == arr[mid]) {
				return mid;
			} else if (x < arr[mid]) {
				return findEndIndex(arr, low, mid - 1, x, totalElements);
			} else {
				return findEndIndex(arr, mid + 1, high, x, totalElements);
			}
		}
		return -1;
	}
}