package chap04;

import java.util.Arrays;
import java.util.Scanner;

// 2018 - 수들의 합 5
public class 투포인터_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int start = 0, end = 0; // 시작, 끝 포인터
        int M = 1; // 부분합 저장
        int count = 0; //경우의 수 저장

        while (end < N) {
            if (M == N) {
                count++; // 경우의 수 증가
                end++;
                if (end < N) M += arr[end];
            } else if (M > N) {
                M -= arr[start];
                start++;
            } else {
                end++;
                M += arr[end];
            }
            //System.out.printf("start: %d, end: %d, M: %d, count: %d\n", start, end, M, count);

        }
        System.out.println(count);
    }
}
