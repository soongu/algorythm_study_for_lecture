package chap05.queue;

public class Main {

    public static void main(String[] args) {

        Queue<Number> queue = new Queue<Number>(); // 새로운 스택 생성

        // 스택에 자료 넣기
        for (int i = 1; i <= 5; i++) {
            queue.insert(i * 3);
        }


        // 스택에 모든 자료를 제거하면서 제거된 자료 출력
        while (!queue.isEmpty()) {
            Long removed = queue.remove();
            System.out.println(removed);
        }

    }
}
