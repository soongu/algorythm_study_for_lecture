package chap02.linked_list.simple;

public class Test {

    public static void main(String[] args) {

        SimpleLinkedList list = new SimpleLinkedList();
        list.insert(3);
        list.insert(1);
        list.insert(8);
        list.insert(11);
        list.insert(5);
        list.insert(7);
        list.insert(14);

        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        list.addFirst(2);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);
    }
}
