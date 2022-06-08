package chap05.stack;

public class Main {

    public static void main(String[] args) {

        Stack stack = new Stack(); // 새로운 스택 생성

        // 스택에 자료 넣기
        for (int i = 1; i <= 5; i++) {
            stack.push(i * 3);
        }


        // 스택에 모든 자료를 제거하면서 제거된 자료 출력
        while (!stack.isEmpty()) {
            Long removed = stack.pop();
            System.out.println(removed);
        }

        stack.peek();

    }
}
