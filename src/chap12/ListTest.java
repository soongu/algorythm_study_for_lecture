package chap12;

public class ListTest {

    public static void main(String[] args) {

        Graph_List gl = new Graph_List();
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");

        gl.addVertex(A);
        gl.addVertex(B);
        gl.addVertex(C);
        gl.addVertex(D);
        gl.addVertex(E);

        gl.addEdge(A, B);
        gl.addEdge(B, E);
        gl.addEdge(E, D);
        gl.addEdge(B, C);

        gl.showMatrix();
    }
}
