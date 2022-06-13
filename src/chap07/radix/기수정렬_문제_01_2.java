package chap07.radix;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 백준 10989
public class 기수정렬_문제_01_2 {


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

        int digit = 1;
        int maxSize = 5;
        int count = 0;
        int[] output = new int[arr.length];

        while (count != maxSize) {
            int[] bucket = new int[10];
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / digit) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                output[bucket[(arr[i] / digit % 10)] - 1] = arr[i];
                bucket[(arr[i] / digit) % 10]--;
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
            digit *= 10;
            count++;
        }

    }
}
