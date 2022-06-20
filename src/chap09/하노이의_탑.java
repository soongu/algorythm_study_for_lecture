package chap09;

//백준 11729
public class 하노이의_탑 {

    public static void moveDisk(int top, char from, char mid, char to) {
        if (top == 1) {
            System.out.printf("원판 %d이 기둥%c에서 기둥%c로 이동\n", top, from, to);
        } else {
            moveDisk(top - 1, from, to, mid); // from에서 mid로 이동
            System.out.printf("원판 %d이 기둥%c에서 기둥%c로 이동\n", top, from, to);
            moveDisk(top - 1, mid, from, to); // mid에서 to로 이동
        }
    }

    public static void main(String[] args) {

        moveDisk(4, 'A', 'B', 'C');
    }
}
