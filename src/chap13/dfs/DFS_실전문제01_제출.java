package chap13.dfs;
/*

    1. 그래프를 인접 리스트 형태로 구현하고 DFS를 수행합니다.
    2. 정점의 수만큼 방문배열을 만들고 DFS를 진행하여 방문배열값을 true로 초기화합니다.
    3. 모든 방문배열의 값이 true가 되어 탐색을 마쳤을 때 DFS가 몇번 일어났는지를 세면
       연결된 컴포넌트의 개수를 알 수 있습니다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 11724
public class DFS_실전문제01_제출 {


    static List<List<Integer>> adjList = new LinkedList<>(); // 그래프 인접 리스트
    static boolean[] visited; // 방문배열

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //  정점 수
        int M = Integer.parseInt(st.nextToken()); //  간선 수

        // 정점 수만큼 인접 리스트 초기화
        for (int i = 0; i < N; i++) {
            adjList.add(new LinkedList<>());
        }
        // 정점 수만큼 방문 배열 초기화
        visited = new boolean[N];

        // 간선 수만큼 인접 리스트에 연결정보 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작점
            int e = Integer.parseInt(st.nextToken()); // 끝점
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
        if (visited[v]) return;
        visited[v] = true;

        List<Integer> connectedList = adjList.get(v);
        for (Integer n : connectedList) {
            if (!visited[n - 1]) DFS(n - 1);
        }
    }
}











