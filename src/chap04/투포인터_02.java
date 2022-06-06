package chap04;

import java.util.Arrays;
import java.util.Scanner;

// 1940 - 주몽의 명령
public class 투포인터_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); // 재료의 개수
        int N = sc.nextInt(); // 갑옷이 완성되는 번호의 합
        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(arr);

        int count = 0;
        int start = 0, end = K - 1;
        int M;

        while (start < end) {
            M = arr[start] + arr[end];
            if (M == N) {
                count++; // 경우의 수 증가
                start++;
                end--;
            } else if (M > N) {
                end--;
            } else {
                start++;
            }

            //System.out.printf("start: %d, end: %d, M: %d, count: %d\n", start, end, M, count);

        }
        System.out.println(count);
    }
}
