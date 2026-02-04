import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] people;
	static ArrayList<Integer>[] graph;
	static boolean[] selected;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j=0; j<M; j++) {
				int v = Integer.parseInt(st.nextToken());
				graph[i].add(v);
			}
		}
		
		selected = new boolean[N+1];
		subset(1);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	static void subset(int idx) {
		if(idx == N+1) {
			if(isConnected(true) && isConnected(false)) {
				sum();
			}
			return;
		}
			
		selected[idx] = true;
		subset(idx+1);
		
		selected[idx] = false;
		subset(idx+1);
	}
	
	static boolean isConnected(boolean group) {
		visited = new boolean[N+1];

		int start = -1;
		for (int i = 1; i <= N; i++) {
		    if (selected[i] == group) {
		        start = i;
		        break;
		    }
		}
		if (start == -1) return false;

        dfs(start, group);

        for(int i=1; i<=N; i++) {
        	if(selected[i] == group && !visited[i]) {
        		return false;
        	}
        }

        return true;
	}
	
	static void dfs(int cur, boolean group) {
		visited[cur] = true;

		for(int next : graph[cur]) {
			if(!visited[next] && selected[next] == group) {
				dfs(next, group);
			}
		}
	}
	
	static void sum() {
		int sumA = 0;
		int sumB = 0;
		
		for(int i=1; i<=N; i++) {
			if(selected[i]) {
				sumA += people[i-1];
			} else {
				sumB += people[i-1];
			}
		}

		int diff = Math.abs(sumA-sumB);

        answer = Math.min(answer, diff);
    }

}
