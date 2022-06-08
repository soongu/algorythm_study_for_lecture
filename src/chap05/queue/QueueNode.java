package chap05.queue;

class QueueNode {

    private long queueItem;
    private QueueNode link;

    public long getQueueItem() {
        return queueItem;
    }

    public void setQueueItem(long queueItem) {
        this.queueItem = queueItem;
    }

    public QueueNode getLink() {
        return link;
    }

    public void setLink(QueueNode link) {
        this.link = link;
    }
}
