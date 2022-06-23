package chap12;
// 인접행렬 방식



public class Graph_Matrix {

    public static final int MAX = 50; // 최대 정점 개수

    private int[][] adjMat; // 그래프의 방향을 저장할 인접 행렬
    private Vertex[] vertices; // 정점 배열
    private int numOfVertice; // 현재 그래프에 연결된 정점의 수


    public Graph_Matrix() {
        adjMat = new int[MAX][MAX];
        vertices = new Vertex[MAX];
    }

    // 정점 추가
    public void addVertex(Vertex v) {
        v.setId(numOfVertice); // 정점에 아이디 부여
        vertices[numOfVertice] = v; // 정점 배열에 추가
        numOfVertice++;
    }

    // 간선 추가
    public void addEdge(Vertex departure, Vertex destination) {
        adjMat[departure.getId()][destination.getId()] = 1;
        adjMat[destination.getId()][departure.getId()] = 1;
    }

    // 인접 행렬 출력
    public void showMatrix() {
        System.out.print("    ");
        for (int i = 0; i < numOfVertice; i++) {
            System.out.print(vertices[i].getLabel() + " ");
        }
        System.out.println();

        for (int i = 0; i < numOfVertice; i++) {
            System.out.printf("%s | ", vertices[i].getLabel());
            for (int j = 0; j < numOfVertice; j++) {
                System.out.printf("%d ", adjMat[i][j]);
            }
            System.out.println();
        }


    }

}








