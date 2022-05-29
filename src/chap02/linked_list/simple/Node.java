package chap02.linked_list.simple;

public class Node {

    private int data; // 노드에 저장할 데이터
    private Node nextNode;  // 다음 노드의 주소를 저장할 포인터

    public Node(int data) {
        this.data = data;
    }


    // 노드의 자료에 접근하는 메서드
    public int getData() {
        return data;
    }

    // 노드의 자료를 변경하는 메서드

    public void setData(int data) {
        this.data = data;
    }

    // 다음 노드에 접근하는 메서드
    public Node getNextNode() {
        return nextNode;
    }

    // 다음 노드를 변경하는 메서드
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
