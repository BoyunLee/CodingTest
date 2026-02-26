import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, List<String>> graph = new HashMap<>();
		Map<String, Integer> indegree = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String u = st.nextToken();
			String v = st.nextToken();
			
			graph.putIfAbsent(u, new ArrayList<>());
			graph.putIfAbsent(v, new ArrayList<>());
			
			graph.get(u).add(v);
			
			indegree.put(v, indegree.getOrDefault(v, 0)+1);
			indegree.putIfAbsent(u, 0);
		}
		
		Queue<String> curPQ = new PriorityQueue<>();
		Queue<String> nextPQ = new PriorityQueue<>();
		for(String key : indegree.keySet()) {
			if(indegree.get(key) == 0) {
				curPQ.offer(key);
			}
		}
		
		List<String> answer = new ArrayList<>();
		
		while(!curPQ.isEmpty()) {
			while(!curPQ.isEmpty()) {
				String cur = curPQ.poll();
		        answer.add(cur);
	
		        for (String next : graph.get(cur)) {
		            indegree.put(next, indegree.get(next) - 1);
		            if (indegree.get(next) == 0) {
		                nextPQ.offer(next);
		            }
		        }
			}
			curPQ = nextPQ;
            nextPQ = new PriorityQueue<>();
		}
			
		if(answer.size() != indegree.size()) {
			System.out.println(-1);
		} else {
			for(String a : answer) {
				System.out.println(a);
			}
		}
	}
}
