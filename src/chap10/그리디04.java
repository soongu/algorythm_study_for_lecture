package chap10;

/*
     가장 작은 값을 만드려면 가능한 큰 수를 빼줘야 함.
     따라서 더하기를 먼저 계산한 후 뺄셈을 진행해줘야 함.
 */

import java.util.Scanner;
import java.util.StringTokenizer;

// 백준 1541
public class 그리디04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int answer = 0;

        // 100-40+50+74-30+29-45+43+11
        // 100 - 164 - 59 - 99 = -222
        String str = sc.nextLine();

        // - 기호를 기준으로 자름
        StringTokenizer st = new StringTokenizer(str, "-");
        for (int i = 0; st.hasMoreTokens(); i++) {
            int addSum = calcTotal(st.nextToken());
            if (i == 0) {
                answer += addSum;
            } else {
                answer -= addSum;
            }
        }
        System.out.println(answer);
    }

    private static int calcTotal(String s) {
        int total = 0;
        StringTokenizer st = new StringTokenizer(s, "+");
        while (st.hasMoreTokens()) {
            total += Integer.parseInt(st.nextToken());
        }
        return total;
    }
}
