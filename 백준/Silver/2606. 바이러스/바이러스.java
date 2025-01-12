import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int computer = sc.nextInt();
        int n = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= computer; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[computer + 1];

        dfs(1);

        System.out.println(count - 1);       
    }

    private static void dfs(int x) {
        visited[x] = true;
        count++;

        for (int i : graph.get(x)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}