import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            List<Integer>[] graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            // 전선 하나를 제외한 나머지 전선으로 그래프 구성
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // 제외할 전선
                graph[wires[j][0]].add(wires[j][1]);
                graph[wires[j][1]].add(wires[j][0]);
            }

            // 두 컴포넌트 크기 계산
            boolean[] visited = new boolean[n + 1];
            int size1 = bfs(graph, visited, wires[i][0]);
            int size2 = n - size1;

            // 두 컴포넌트 크기 차이 계산
            answer = Math.min(answer, Math.abs(size1 - size2));
        }

        return answer;
    }

    private int bfs(List<Integer>[] graph, boolean[] visited, int start) {
        int size = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            size++;

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return size;
    }
}
