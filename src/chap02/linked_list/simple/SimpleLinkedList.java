package chap02.linked_list.simple;

public class SimpleLinkedList {

    private HeaderNode header;

    // 리스트 초기 생성시, 헤더노드 같이 생성
    public SimpleLinkedList() {
        header = new HeaderNode();
    }

    // 리스트의 첫번째 자리로 노드를 삽입하는 메서드
    public void addFirst(int data) {
        // 새로운 노드 생성
        Node newNode = new Node(data);

        // 새로운 노드는 기존의 첫번째 노드의 주소를 기억
        newNode.setNextNode(header.getFirstNode());

        // 헤더는 새로운 노드의 주소를 기억
        header.setFirstNode(newNode);
    }

    // 리스트의 첫번째 자리 노드 삭제 메서드
    public Node removeFirst() {
        // 빈 리스트인지 확인
        if (!header.isEmpty()) {
            // 삭제 대상 노드를 키핑
            Node tempNode = header.getFirstNode();

            // 헤더노드가 기존 두번째 노드를 기억하도록 처리
            header.setFirstNode(header.getFirstNode().getNextNode());

            // 삭제된 노드를 반환
            return tempNode;
        } else {
            return null; // 빈 리스트라면 null 반환
        }
    }

    // 정렬된 리스트에서 특정 위치에 노드 삽입
    public void insert(int data) {
        // 새로운 노드 생성
        Node newNode = new Node(data);

        // 첫번째 노드 가져와서 현재 노드로 설정
        Node current = header.getFirstNode();
        // 이전 노드를 저장할 변수 선언
        Node prev = null;

        // 삽입 위치 탐색
        // 빈 리스트가 아니고 삽입할 데이터가 현재노드의 데이터보다 클 동안에 반복
        while (current != null && data > current.getData()) {
            prev = current;  // 현재 노드를 이전 노드에 저장하고
            current = current.getNextNode(); // 다음 노드를 현재 노드로 설정정
        }

        // 빈 리스트일 경우
        if (prev == null) {
            // 새로운 노드를 첫번째 위치에 삽입
            header.setFirstNode(newNode);
        } else { // 빈 리스트가 아닐 경우
            // 이전 노드가 새로운 노드를 가리키도록 변경
            prev.setNextNode(newNode);
        }
        // 새로운 노드가 현재노드를 가리키도록 변경
        newNode.setNextNode(current);
    }

    // 정렬된 리스트에서 특정 위치 노드 삭제하기
    public Node remove(int data) {

        // 첫번째 노드 가져와서 현재 노드로 설정
        Node current = header.getFirstNode();
        // 이전 노드를 저장할 변수 선언
        Node prev = null;

        // 삭제 대상 노드 탐색
        // 빈 리스트가 아니고 삭제할 데이터가 현재노드의 데이터가 아닌 동안에 반복
        while (current != null && data != current.getData()) {
            prev = current;  // 현재 노드를 이전 노드에 저장하고
            current = current.getNextNode(); // 다음 노드를 현재 노드로 설정정
        }

        if (prev == null && current != null) { // 삭제대상이 첫번째 노드인 경우
            // 헤더가 두번째 노드를 기억하게 함
            header.setFirstNode(current.getNextNode());
        } else if (prev != null && current != null) { // 삭제 대상이 중간 어딘가일 경우
            // 이전 노드가 다음 노드를 기억하도록 변경
            prev.setNextNode(current.getNextNode());
        }
        return current; // 삭제 대상노드 반환
    }

    public String toString() {
        String msg = "[ ";
        Node current = header.getFirstNode();
        while (current != null) {
            msg += current.getData();
            current = current.getNextNode();
            if (current != null) {
                msg += ", ";
            }
        }
        msg += " ]";
        return msg;
    }

}
