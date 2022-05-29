package chap03;

import java.util.Scanner;

public class 구간_합구하기1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), M = sc.nextInt();
        long[] S = new long[N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                S[0] = sc.nextInt();
                continue;
            }
            S[i] = S[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
            long sy = S[y];
            long sx = (x == 0) ? 0 : S[x-1];

            System.out.println(sy - sx);
        }
    }
}
