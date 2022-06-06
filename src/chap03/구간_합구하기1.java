package chap03;

import java.util.Scanner;

public class 구간_합구하기1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), M = sc.nextInt();
        long[] S = new long[N + 1];

        for (int i = 1; i < N + 1; i++) {
            S[i] = S[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            System.out.println(S[y] - S[x-1]);
        }
    }
}
