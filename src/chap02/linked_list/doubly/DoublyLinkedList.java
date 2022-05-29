package chap02.linked_list.doubly;

public class DoublyLinkedList {

    private HeaderNode header;

    public DoublyLinkedList() {
        header = new HeaderNode();
    }

    // 리스트에 노드를 삽입하는 메서드
    public void insert(int data) {
        // 새로운 노드 생성
        Node newNode = new Node(data);

        // 첫번째 노드부터 검색
        Node current = header.getFirstNode();
        Node prev = null;

        while (current != null && data > current.getData()) {
            prev = current;
            current = current.getNextNode();
        }

        // 빈 리스트일 경우
        if (header.isEmpty()) {
            // 새로운 노드를 첫번쨰 자리로 삽입 후 앞 뒤 노드를 null 로 셋팅
            header.setFirstNode(newNode);
            newNode.setNextNode(null);
            newNode.setPrevNode(null);
        }
        // 새로운 노드가 첫 위치에 삽입되는 경우
        else if (header.getFirstNode() == current) {
            newNode.setNextNode(header.getFirstNode());
            header.setFirstNode(newNode);
            newNode.setPrevNode(null);
        }
        // 새로운 노드가 마지막 위치에 삽입되는 경우
        else if (current == null) {
            prev.setNextNode(newNode);
            newNode.setPrevNode(prev);
            newNode.setNextNode(null);
        }
        // 새로운 노드가 중간 위치에 삽입되는 경우
        else {
            // 새로운 노드의 다음노드로 이전노드의 기존 다음노드를 설정
            newNode.setNextNode(prev.getNextNode());
            // 이전노드의 다음노드로 새로운 노드를 설정
            prev.setNextNode(newNode);
            // 새 노드의 이전노드로 기존 이전노드를 설정
            newNode.setPrevNode(prev);
            // 새 노드의 다음노드의 이전노드에 새 노드를 설정
            newNode.getNextNode().setPrevNode(newNode);
        }
    }
}
