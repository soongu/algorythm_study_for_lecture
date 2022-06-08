package chap05.queue;

public class Queue {

    private QueueNode front;
    private QueueNode rear;

    public Queue() {
        front = new QueueNode();
        rear = new QueueNode();
    }

    public boolean isEmpty() {
        return front.getLink() == null;
    }

    // 큐의 rear에 자료 삽입
    public void insert(long item) {
        QueueNode newNode = new QueueNode();
        newNode.setQueueItem(item); // 새로운 노드에 자료 저장

        if (isEmpty()) { // 큐가 비어 있는 경우
            front.setLink(newNode);
            rear.setLink(newNode);
        } else {
            QueueNode lastNode = rear.getLink();
            lastNode.setLink(newNode);
            rear.setLink(newNode);
        }
    }

    // 큐의 front에서 자료 제거
    public Long remove() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return null;
        } else {
            QueueNode first = front.getLink();
            long removed = first.getQueueItem();

            front.setLink(first.getLink());
            return removed;
        }
    }
}
