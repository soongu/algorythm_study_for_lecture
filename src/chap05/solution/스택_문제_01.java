package chap05.solution;


import java.util.Scanner;
import java.util.Stack;

// 백준 1874
public class 스택_문제_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int num = 1; // 자연수 값
        boolean result = false; // NO를 출력한 여부

        for (int i = 0; i < A.length; i++) {
            int su = A[i]; // 현재 수열값
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int n = stack.pop();

                // 스택의 가장 위의 수가 현재 수열값보다 크면 수열을 출력할 수 없음
                if (n > su) {
                    System.out.println("NO");
                    result = true;
                    break;
                } else {
                    sb.append("-\n");
                }
            }

        }

        if (!result) System.out.println(sb);
    }
}










