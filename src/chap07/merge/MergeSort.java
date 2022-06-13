package chap07.merge;

import java.util.Arrays;

public class MergeSort {

    private static int[] temp; // 병합 작업에 쓸 임시 배열

    public static void sort(int[] arr) {
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        temp = null;
    }

    private static void mergeSort(int[] arr, int s, int e) {

        if (e - s < 1) return; // 부분 리스트의 원소가 1개 이하면 return

        int m = (s + e) / 2; // 배열 중앙 위치

        // 분할 작업
        mergeSort(arr, s, m);
        mergeSort(arr,m + 1, e);

        // 병합 작업

        // 부분 배열 임시 배열에 저장
        for (int i = s; i <= e; i++) {
            temp[i] = arr[i];
        }

        int target = s; // 정렬 완성 배열 값을 채우기 위한 인덱스 포인터
        int p1 = s;     // 첫번째 그룹 포인터
        int p2 = m + 1; // 두번째 그룹 포인터

        while (p1 <= m && p2 <= e) {
            if (temp[p1] > temp[p2]) {
                arr[target++] = temp[p2++];
            } else {
                arr[target++] = temp[p1++];
            }
        }

        /*
            오른쪽 리스트가 먼저 소모된 경우, 왼쪽 리스트는 아직 데이터가 남아있기 때문에
            마저 처리해준다.
         */
        while (p1 <= m) {
           arr[target++] = temp[p1++];
        }

        /*
            왼쪽 리스트가 먼저 소모된 경우, 오른쪽 리스트는 아직 데이터가 남아있기 때문에
            마저 처리해준다.
         */
        while (p2 <= e) {
            arr[target++] = temp[p2++];
        }


    }

    public static void main(String[] args) {

        int[] arr = {1, 11, 88, 55, 99, 77, 66, 44, 22, 33};
        sort(arr);

        System.out.println("정렬 후: " + Arrays.toString(arr));
    }
}
