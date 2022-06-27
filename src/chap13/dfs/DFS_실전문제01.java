package chap13.dfs;
/*

    1. 그래프를 인접 리스트 형태로 구현하고 DFS를 수행합니다.
    2. 정점의 수만큼 방문배열을 만들고 DFS를 진행하여 방문배열값을 true로 초기화합니다.
    3. 모든 방문배열의 값이 true가 되어 탐색을 마쳤을 때 DFS가 몇번 일어났는지를 세면
       연결된 컴포넌트의 개수를 알 수 있습니다.

 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// 백준 11724
public class DFS_실전문제01 {

    static List<List<Integer>> adjList = new LinkedList<>(); // 그래프 인접 리스트
    static boolean[] visited;  // 방문 배열

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //  정점 수
        int M = sc.nextInt(); //  간선 수

        // 정점 수만큼 인접 리스트 초기화
        for (int i = 0; i < N; i++) {
            adjList.add(new LinkedList<>());
        }
        // 정점 수만큼 방문 배열 초기화
        visited = new boolean[N];

        // 간선 수만큼 인접 리스트에 연결정보 추가
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt(); // 시작점
            int e = sc.nextInt(); // 끝점
            // 단, 무방향 그래프이므로 양쪽 다 추가한다.
            adjList.get(s - 1).add(e);
            adjList.get(e - 1).add(s);
        }

        int count = 0; // DFS 횟수 기록

        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 방문하지 않은 정점이 없을 때까지
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    // DFS
    private static void DFS(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v + 1);

        while (!stack.isEmpty()) {
            int vertex = stack.pop(); // 스택에서 정점을 꺼낸다
            visited[vertex - 1] = true; // 해당 정점 방문처리

            List<Integer> connectedList = adjList.get(vertex - 1); // 해당 정점에 연결된 정점들 꺼내기
            for (Integer n : connectedList) {
                if (!visited[n - 1]) {
                    stack.push(n); // 방문하지 않은 정점을 스택에 추가
                }
            }
        }
    }


}











