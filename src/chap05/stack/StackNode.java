package chap05.stack;

class StackNode {
    private long stackItem; // 스택에 저장될 자료
    private StackNode link; // 다음 자료 연결 포인터

    public long getStackItem() {
        return stackItem;
    }

    public void setStackItem(long stackItem) {
        this.stackItem = stackItem;
    }

    public StackNode getLink() {
        return link;
    }

    public void setLink(StackNode link) {
        this.link = link;
    }
}
