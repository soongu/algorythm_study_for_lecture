package chap07.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

       |                 |
       0   1   2   3     4  5   6   7
    [ 24, 32, 42, 60 ] [ 5, 15, 45, 90 ]

    [  5 ]

    - 병합 과정에서 뒤쪽 배열의 값이 작은경우 5의 값이 4번인덱스에서 0번으로 이동하므로
      버블정렬에서 4번 스왑이 일어났다고 볼 수 있음

                             |  |
       0   1   2   3     4   5  6   7
    [ 24, 32, 42, 60 ] [ 5, 15, 45, 90 ]

    [  5, 15, 24, 32  , 42, 45 ]

    - 병합 과정에서 뒤쪽 배열의 값이 작은경우 45의 값이 6번인덱스에서 5번으로 이동하므로
      버블정렬에서 1번 스왑이 일어났다고 볼 수 있음

 */

//백준 1517
public class 병합정렬_문제_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        sort(A);

        System.out.println(count);

    }

    private static int[] temp; // 병합 작업에 쓸 임시 배열
    private static long count;

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
                count += (p2 - target);
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
}
