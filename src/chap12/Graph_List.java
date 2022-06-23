package chap12;
// 인접리스트 방식


import java.util.LinkedList;
import java.util.List;

public class Graph_List {


    private List<List<Vertex>> adjList; // 그래프의 방향을 저장할 인접 행렬
    private List<Vertex> vertices; // 정점 배열


    public Graph_List() {
        adjList = new LinkedList<>();
        vertices = new LinkedList<>();
    }

    // 정점 추가
    public void addVertex(Vertex v) {
        v.setId(vertices.size()); // 정점에 아이디 부여
        vertices.add(v); // 정점 리스트에 추가
        adjList.add(new LinkedList<>()); // 인접리스트에 1차원 리스트 추가
    }

    // 간선 추가
    public void addEdge(Vertex departure, Vertex destination) {

        adjList.get(departure.getId()).add(destination);
        adjList.get(destination.getId()).add(departure);
    }

    // 인접 행렬 출력
    public void showMatrix() {

        for (int i = 0; i < adjList.size(); i++) {
            System.out.printf("%s | ", vertices.get(i).getLabel());
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.printf("%s ", adjList.get(i).get(j).getLabel());
            }
            System.out.println();
        }


    }

}








