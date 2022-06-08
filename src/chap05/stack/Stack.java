package chap05.stack;

public class Stack {

    private StackNode top; // 스택의 top

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return top == null;
    }

    // 스택의 top에 자료 삽입
    public void push(long item) {

        // 새 노드 생성
        StackNode newNode = new StackNode();

        newNode.setStackItem(item); // 새 노드에 자료 저장
        newNode.setLink(top); // 새 노드가 top이 가리키던 노드를 가리키도록 함
        top = newNode; // top이 새 노드를 가리키도록 변경

    }

    // 스택의 top으로부터 자료 제거
    public Long pop() {
        if (isEmpty()) { // 스택이 빈 경우
            System.out.println("stack is empty");
            return null;
        } else {
            long result = top.getStackItem(); // top이 가리키던 자료 전달
            top = top.getLink(); // top이 제거된 노드의 다음 노드를 가리키도록 변경
            return result;
        }
    }

    // 스택의 top으로부터 자료 읽기
    public Long peek() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return null;
        } else {
            return top.getStackItem();
        }
    }

}
