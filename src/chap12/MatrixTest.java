package chap12;

public class MatrixTest {

    public static void main(String[] args) {

        Graph_Matrix gm = new Graph_Matrix();
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");

        gm.addVertex(A);
        gm.addVertex(B);
        gm.addVertex(C);
        gm.addVertex(D);
        gm.addVertex(E);

        gm.addEdge(A, B);
        gm.addEdge(B, E);
        gm.addEdge(E, D);
        gm.addEdge(B, C);

        gm.showMatrix();
    }
}
