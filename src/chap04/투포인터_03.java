package chap04;

import java.util.Arrays;
import java.util.Scanner;

// 백준 1253
public class 투포인터_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수의 개수

        int result = 0; // 좋은 수의 개수

        long[] A = new long[N]; // 수를 담을 배열
        // 배열 초기화
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }
        sc.close();

        // 배열 정렬
        Arrays.sort(A);

        // 모든 수를 순회하며 좋은 수인지 판단하기
        for (int i = 0; i < A.length; i++) {
            long target = A[i]; // 좋은 수 판단 타겟
            int start = 0; // 투포인터 시작포인터
            int end = N - 1; // 투포인터 끝포인터

            // 투포인터 알고리즘
            while (start < end) {
                if (A[start] + A[end] == target) { // 두 수의 합으로 좋은 수가 나오는지 판단
                    if (start != i && end != i) { // target은 자기자신이 아닌 서로 다른 위치의 합인지 확인
                        result++; // 경우의 수 증가
                        break;
                    } else if (start == i) { // 시작포인터가 자기 자신을 가리킬 경우
                        start++; // 시작포인터 한칸 이동
                    } else if (end == i) { // 끝포인터가 자기 자신을 가리킬 경우
                        end--; // 끝 포인터 한칸 이동
                    }
                } else if (A[start] + A[end] < target) { // 두 수의 합이 판단타겟 수보다 작은 경우
                    start++; // 판단타겟 수에 가까워지도록 시작포인터 이동
                } else { // 두 수의 합이 판단타겟 수보다 큰 경우
                    end--; // 판단타겟 수에 가까워지도록 끝포인터 이동
                }
            } // end while
        }// end for

        System.out.println(result);

    }
}
