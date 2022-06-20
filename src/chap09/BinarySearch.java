package chap09;

public class BinarySearch {


    // 이진 탐색 - recursive
    public static int binarySearch(int[] arr, int target) {
        return bsRec(arr, target, 0, arr.length - 1);
    }

    static int n = 1;

    public static int bsRec(int[] arr, int target, int left, int right) {
        System.out.println(n++ + "회차 호출!!");

        int mid = (left + right) / 2;
        ;

        if (target == arr[mid]) {
            System.out.println("mid: " + mid + " 리턴!");
            return mid;
        } else if (left > right) {
            System.out.println("-1 리턴");
            return -1;
        } else {
            if (target < arr[mid]) {
                int result = bsRec(arr, target, left, mid - 1);
                System.out.println("result1: " + result + " 리턴!");
                return result;
            } else {

                int result = bsRec(arr, target, mid + 1, right);
                System.out.println("result2: " + result + " 리턴!");
                return result;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 7, 11, 12, 27, 49, 53, 68, 72, 91};

        int target = 53;
        System.out.printf("Linear Search(%d's index): %d\n", target, binarySearch(arr, target));
    }
}
