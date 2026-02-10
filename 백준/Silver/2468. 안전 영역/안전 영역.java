import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] copy;
	static int maxHeight;
	static Set<Integer> set;
	static int[] height;
	static int safeArea;
	static int answer;
	static Queue<int[]> queue;
	static boolean[][] visited; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		maxHeight = 0;
		set = new HashSet<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				set.add(map[i][j]);
			}
		}
		
		int M = set.size();
		height = new int[M];
		int index = 0;
		for(int s : set) {
			height[index] = s;
			index++;
		}
		
		Arrays.sort(height);
		
		answer = 1;
		for(int i=0; i<M; i++) {
			rainy(height[i]);
			answer = Math.max(answer, safeArea);
		}
		
		System.out.println(answer);
	}
	
	static void rainy(int height) {
		copy = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				copy[i][j] = map[i][j] - height;
			}
		}
		safe();
	}
	
	static void safe() {
		safeArea = 0;

		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(copy[i][j] > 0 && !visited[i][j]) {
					safeArea++;
					bfs(i, j);
				}
			}
		}
	}
	
	static void bfs(int i, int j) {
		queue = new ArrayDeque<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0]; 
			int c = temp[1];
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(copy[nr][nc] > 0 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
	}
}