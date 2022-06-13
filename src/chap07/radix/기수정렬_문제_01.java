package chap07.radix;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 백준 10989
public class 기수정렬_문제_01 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        sort(A);

        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();

//        StringBuilder sb = new StringBuilder();
//        for (int i : A) {
//            sb.append(i).append("\n");
//        }
//        System.out.println(sb);

    }

    public static void sort(int[] arr) {
        // 자리수 구하기
        int digit = 0;
        for (int n : arr) {
            int length = String.valueOf(n).length();
            if (length > digit) {
                digit = length;
            }
        }

        // 10개의 큐 생성
        Queue<Integer>[] queues = new Queue[10];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<>();
        }


        for (int i = 0; i < digit; i++) { // 자리수만큼 반복

            for (int j = 0; j < arr.length; j++) {
                // 각 숫자에서 i = 0일 때는 1의자리 수 뽑기, i = 1일 때는 10의 자리수 뽑기...
                // 예를 들어 754에서 i가 0일때는 4를 뽑아야하고 i가 1일때는 5를 뽑아야 하니까
                // 754 / 1 % 10 하면 4 , 754 / 10 % 10 하면 5, 754 / 100 % 10 하면 7 ...
                int idx = arr[j] / (int) Math.pow(10, i) % 10;

                // 해당 숫자에 맞는 큐에 저장
                queues[idx].add(arr[j]);
            }

            // 큐에서 순서대로 poll하여 배열에 재 저장
            int k = 0; // 배열 저장 위치
            for (Queue<Integer> q : queues) {
                while (!q.isEmpty()) {
                    arr[k++] = q.poll();
                }
            }

        }

    }
}
