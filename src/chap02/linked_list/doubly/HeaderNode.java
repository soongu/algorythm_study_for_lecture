package chap02.linked_list.doubly;


public class HeaderNode {

    private Node firstNode;
    private Node lastNode;

    public HeaderNode() {
        this.firstNode = null;
    }

    // 헤더노드를 참조하는 메서드
    public Node getFirstNode() {
        return firstNode;
    }

    // 헤더노드의 포인터를 변경하는 메서드
    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }

    // 연결리스트가 비어있는지 확인
    public boolean isEmpty() {
        return firstNode == null;
    }
}
