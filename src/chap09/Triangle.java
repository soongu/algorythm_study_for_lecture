package chap09;

public class Triangle {

    // 삼각수 루프로 구하기
    public static int triLoop(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }

    // 삼각수 재귀로 구하기
    public static int triRec(int n) {
        if (n == 1) return 1;
        return n + triRec(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(triLoop(4));
        System.out.println(triRec(4));
    }
}
