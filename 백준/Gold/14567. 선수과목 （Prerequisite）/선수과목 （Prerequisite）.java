import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] lists = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			lists[i] = new ArrayList<>();
		}
		
		int[] indeg = new int[N+1];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lists[a].add(b);
			indeg[b]++;
		}
		
		int[] answer = new int[N+1];
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			answer[i] = 1;
			if(indeg[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int next : lists[cur]) {
				answer[next] = Math.max(answer[next], answer[cur] + 1);

                indeg[next]--;
                if (indeg[next] == 0) queue.add(next);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(answer[i]).append(' ');
		}
		System.out.println(sb.toString().trim());
	}
}
