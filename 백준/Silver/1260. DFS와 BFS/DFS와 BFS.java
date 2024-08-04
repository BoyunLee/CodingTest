import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[][] adjMatrix;
    static int nodeCount, edgeCount, startNode;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());
        
        adjMatrix = new int[nodeCount + 1][nodeCount + 1];
        visited = new boolean[nodeCount + 1];
        
        // 간선 정보를 읽어 인접 행렬을 채움
        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer edgeTokens = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(edgeTokens.nextToken());
            int node2 = Integer.parseInt(edgeTokens.nextToken());
            adjMatrix[node1][node2] = adjMatrix[node2][node1] = 1;
        }
        
        // DFS 실행
        dfs(startNode);
        sb.append("\n");
        
        // BFS 실행을 위해 방문 배열 초기화
        Arrays.fill(visited, false);
        
        // BFS 실행
        bfs(startNode);
        
        // 결과 출력
        System.out.println(sb);
    }
    
    public static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        
        for (int i = 1; i <= nodeCount; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            
            for (int i = 1; i <= nodeCount; i++) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
