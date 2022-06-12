package chap06.bubble;

import java.util.Arrays;

public class BubbleSort {

    // swap연산 메서드
    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // bubble sort
    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) { // 비교 항목에 대한 범위 정함
            boolean flag = false; // swap이 일어난 여부
            for (int j = 0; j < i; j++) { // 범위 내 항목 비교
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break; // swap이 한번도 일어나지 않았다면 정렬이 완료되었으므로 반복문 종료
        }
    }

    public static void main(String[] args) {


        int[] arr = {33, 11, 99, 1, 22, 88, 55, 44, 66, 77};

        sort(arr); // 정렬 수행

        System.out.println("정렬 후: " + Arrays.toString(arr));
    }
}
