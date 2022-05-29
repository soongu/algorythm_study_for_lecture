package chap02.linked_list.doubly;

public class Node {

    private int data;
    private Node nextNode;
    private Node prevNode; // 이전 노드를 참조하는 포인터

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

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }
}
