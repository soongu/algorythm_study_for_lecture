package chap13;
// 인접리스트 방식


import chap12.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {


    private List<List<Vertex>> adjList; // 그래프의 방향을 저장할 인접 행렬
    private List<Vertex> vertices; // 정점 배열


    public Graph() {
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

    // 깊이 우선 탐색 - 스택 구현
    public void DFS(Vertex start) {
        // 탐색한 정점을 넣어둘 스택
        Stack<Vertex> stack = new Stack<>();

        stack.push(start); // 시작 정점을 스택에 저장

        Vertex current; // 현재 꺼내올 정점을 담을 변수
        // 스택이 빌 때까지 탐색 수행
        while (!stack.isEmpty()) {
            current = stack.pop(); // 스택에서 정점을 꺼낸다.
            current.setVisitFlag(true); // 해당 정점에 방문처리를 한다.

            // 탐색한 정점의 값을 출력한다.
            System.out.print(current.getLabel() + " ");

            // 해당 정점에 연결되어 있는 다른 정점들을 찾는다.
            List<Vertex> connectedList = adjList.get(current.getId());
            for (int i = 0; i < connectedList.size(); i++) {
                if (!connectedList.get(i).isVisitFlag()) {
                    // 방문하지 않은 정점이면 스택에 넣는다.
                    stack.push(connectedList.get(i));
                }
            }
        }
        System.out.println(); // 줄개행
    }

    // 깊이 우선 탐색 - 재귀 구현
    public void DFS2(Vertex start) {

        if (start.isVisitFlag()) {
            System.out.println();
            return; // 이미 방문했으면 종료
        }

        start.setVisitFlag(true); // 해당 정점 방문 처리
        // 탐색한 정점의 값을 출력한다.
        System.out.print(start.getLabel() + " ");

        List<Vertex> connectedList = adjList.get(start.getId()); // 해당 정점에 연결된 정점리스트

        for (int i = connectedList.size() - 1; i >= 0; i--) {
            Vertex v = connectedList.get(i);
            if (!v.isVisitFlag()) {  // 방문하지 않은 정점들에 대해 재귀 호출
                DFS2(v);
            }
        }

    }

    // 너비 우선 탐색
    public void BFS(Vertex start) {
        // 탐색한 정점을 넣어둘 큐
        Queue<Vertex> queue = new LinkedList<>();

        queue.offer(start); // 시작 정점을 큐에 저장

        Vertex current; // 현재 꺼내올 정점을 담을 변수
        // 큐가 빌 때까지 탐색 수행
        while (!queue.isEmpty()) {
            current = queue.poll(); // 큐에서 정점을 꺼낸다.
            current.setVisitFlag(true); // 해당 정점에 방문처리를 한다.

            // 탐색한 정점의 값을 출력한다.
            System.out.print(current.getLabel() + " ");

            // 해당 정점에 연결되어 있는 다른 정점들을 찾는다.
            List<Vertex> connectedList = adjList.get(current.getId());
            for (int i = 0; i < connectedList.size(); i++) {
                if (!connectedList.get(i).isVisitFlag()) {
                    // 방문하지 않은 정점이면 큐에 넣는다.
                    queue.offer(connectedList.get(i));
                }
            }
        }
        System.out.println(); // 줄개행
    }

}








