package chap02.linked_list.doubly;

public class Test {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insert(10);
        list.insert(3);
        list.insert(2);
        list.insert(5);

        System.out.println(list);

        list.remove(3);
        System.out.println(list);
    }
}
