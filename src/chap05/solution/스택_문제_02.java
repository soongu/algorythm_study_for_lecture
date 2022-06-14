package chap05.solution;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 17298 - 오큰수
public class 스택_문제_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N]; // 수열 배열
        int[] answer = new int[N]; // 정답 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 처음에는 스택이 비어있으므로 항상 최초값을 추가

        // 3 5 2 7    || 5 7 7 -1
        for (int i = 1; i < N; i++) {

            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                answer[stack.pop()] = A[i]; // 정답 배열에 오큰수를 저장
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : answer) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);


    }
}
