package chap10;


import java.util.Comparator;
import java.util.Stack;

public class BinaryTree {

    private Node root; // 트리의 루트 노드

    //============  순회 ===============/

    // 전위 순회
    private void preOrder(Node tempRoot) {
        if (tempRoot != null) {
            System.out.print(tempRoot.getData() + " ");
            preOrder(tempRoot.getLeftChild());
            preOrder(tempRoot.getRightChild());
        }
    }

    // 중위 순회
    private void inOrder(Node tempRoot) {
        if (tempRoot != null) {
            inOrder(tempRoot.getLeftChild());
            System.out.print(tempRoot.getData() + " ");
            inOrder(tempRoot.getRightChild());
        }
    }

    // 후위 순회
    private void postOrder(Node tempRoot) {
        if (tempRoot != null) {
            postOrder(tempRoot.getLeftChild());
            postOrder(tempRoot.getRightChild());
            System.out.print(tempRoot.getData() + " ");
        }
    }

    // 순회
    public void traverse(int type) {
        switch (type) {
            case 1:
                System.out.print("Preorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("Inorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("Postorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    //================== 탐색 ====================//

    public Node find(int targetData) {
        Node current = root;
        while (current.getData() != targetData) {
            if (current == null) return null; // 탐색 실패

            // 찾는 값이 현재 노드의 값보다 작은 경우
            if (targetData < current.getData()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return current; // 탐색 성공, 현재 노드 반환
    }

    //============= 최대, 최소값 탐색 ==================//
    public Node findMin() {
        Node current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }

    public Node findMax() {
        Node current = root;
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }

    //=============== 삽입 ===================//

    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (data < current.getData()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    //====================== 삭제 =====================//

    public boolean delete(int data) {
        Node current = root;
        Node parent = current;

        while (data != current.getData()) {
            if (current == null) return false;

            parent = current;
            if (data < current.getData()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        // 자식이 없을 때
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) { // 루트가 삭제대상
                root = null;
            } else if (current == parent.getLeftChild()) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
            // 자식이 하나일 때 - 왼쪽자식만 존재
        } else if (current.getRightChild() == null) {
            if (current == root) {
                root = current.getLeftChild();
            } else if (current == parent.getLeftChild()) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
            // 자식이 하나일 때 - 오른쪽자식만 존재
        } else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
            } else if (current == parent.getLeftChild()) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
            // 자식이 둘일 때
        } else {
            // 삭제 노드의 후보노드 찾기
            Node candidate = getCandidate(current);

            if (current == root) {
                root = candidate;
            } else if (current == parent.getLeftChild()) {
                parent.setLeftChild(candidate);
            } else {
                parent.setRightChild(candidate);
            }

            candidate.setLeftChild(current.getLeftChild());
        }

        return true;
    }

    // 후보노드를 찾고 후보노드를 삭제노드의 오른쪽노드로 만듦
    private Node getCandidate(Node deleteNode) {

        Node candidateParent = deleteNode;
        Node candidate = candidateParent.getRightChild();

        // 삭제노드 오른족 자식의 왼쪽 자식 찾기
        while (candidate.getLeftChild() != null) {
            candidateParent = candidate;
            candidate = candidate.getLeftChild();
        }

        // 후보노드가 삭제노드 오른쪽 자식의 왼쪽자식일 때
        if (candidate != deleteNode.getRightChild()) {
            candidateParent.setLeftChild(candidate.getRightChild());
            candidate.setRightChild(deleteNode.getRightChild());
        }
        return candidate;
    }

    //================= 트리 출력 ======================//
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);

        int blank = 32;
        boolean isRowEmpty = false;

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;

            for (int i = 0; i < blank; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node temp = globalStack.pop();

                if (temp != null) {
                    System.out.print(temp.getData());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());

                    if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("**");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < blank * 2 - 2; i++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            blank /= 2;

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println();
    }

}
