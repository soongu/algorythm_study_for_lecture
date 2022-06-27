package chap13;

import chap12.Vertex;

public class Test {

    public static void main(String[] args) {

        Graph graph = new Graph();

        // 정점을 생성
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");

        // 정점을 그래프에 추가
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);
        graph.addVertex(F);
        graph.addVertex(G);
        graph.addVertex(H);

        // 간선을 연결
        graph.addEdge(A, B);
        graph.addEdge(A, F);
        graph.addEdge(A, G);
        graph.addEdge(B, C);
        graph.addEdge(B, D);
        graph.addEdge(D, E);
        graph.addEdge(G, H);

        /*
                 A
               / \ \
             B   F  G
           /  \      \
          C    D      H
                \
                 E

         */

        //graph.DFS(A); // A G H F B D E C
        //graph.DFS2(A);
        graph.BFS(A); // A B F G C D H E
    }
}
