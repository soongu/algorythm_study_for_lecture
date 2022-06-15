package chap08;

public class Search {

    // 선형 탐색
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 이진 탐색
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {

            // mid 인덱스값 계산
            mid = (left + right) / 2;

            if (target == arr[mid]) { // 찾고자 하는 값이 mid값과 일치할 경우 탐색 종료
                return mid;
            }

            if (target < arr[mid]) { // 찾고자 하는 값이 mid값보다 작을 경우
                right = mid - 1;
            } else { // 찾고자 하는 값이 mid값보다 클 경우
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {3, 7, 11, 12, 27, 49, 53, 68, 72, 91};

        int target = 53;
        System.out.printf("Linear Search(%d's index): %d\n", target, linearSearch(arr, target));
        System.out.printf("Binary Search(%d's index): %d\n", target, binarySearch(arr, target));
    }
}
