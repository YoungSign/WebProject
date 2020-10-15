package algorithm;

public class BinarySearch {

	//斐波那契数列
	public static void main(String[] args) {
		int[] arr = new int[] { 12, 23, 34, 45, 56, 67, 77, 89, 90 };
		System.out.println(search(arr, 12));
		System.out.println(search(arr, 45));
		System.out.println(search(arr, 67));
		System.out.println(search(arr, 89));
		System.out.println(search(arr, 99));
	}

	public static int search(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (key < arr[middle]) {
				end = middle - 1;
			} else if (key > arr[middle]) {
				start = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
	
//	public static int binarySearch(int[] arr, int start, int end, int hkey){
//	    int result = -1;
//
//	    while (start <= end){
//	        int mid = start + (end - start)/2;    //防止溢位
//	        if (arr[mid] > hkey)
//	            end = mid - 1;
//	        else if (arr[mid] < hkey)
//	            start = mid + 1;
//	        else {
//	            result = mid ;  
//	            break;
//	        }
//	    }
//
//	    return result;
//
//	}
}