package chap12;

public class Vertex {

    private String label;  // 정점 이름
    private boolean visitFlag; // 방문 여부
    private int id; //정점 고유 번호

    public Vertex(String label) {
        this.label = label;
        this.id = -1;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisitFlag() {
        return visitFlag;
    }

    public void setVisitFlag(boolean visitFlag) {
        this.visitFlag = visitFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
