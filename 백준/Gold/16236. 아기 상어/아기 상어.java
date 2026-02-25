import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pair {
		int r;
		int c;
		int dist;
		
		public Pair(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
	static int N;
	static int[][] map;
	static int shark_r;
	static int shark_c;
	static int shark_size;
	static int fish_cnt;
	static int answer;
	
	static PriorityQueue<Pair> fishes; 
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		shark_r = 0;
		shark_c = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark_r = i;
					shark_c = j;
					map[i][j] = 0;
				}
			}
		}
		
		answer = 0;
		shark_size = 2;
		fish_cnt = 0;
		
        while (true) {
            Pair target = searchOne();
            if (target == null) break;

            eatFish(target);
        }

        System.out.println(answer);
	}
	
	static Pair searchOne() {
		boolean[][] visited = new boolean[N][N];
		Queue<Pair> q = new ArrayDeque<>();
		
		fishes = new PriorityQueue<>((a, b) -> {
			if(a.dist != b.dist) {
				return a.dist - b.dist; 
			}
			if(a.r != b.r) {
				return a.r - b.r;
			}
			return a.c - b.c;
		});
		
		q.add(new Pair(shark_r, shark_c, 0));
		visited[shark_r][shark_c] = true;
		
		int minDist = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			if(cur.dist > minDist) break;
			
			for(int d=0; d<4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(isVailed(nr, nc) && !visited[nr][nc]) {
					if(map[nr][nc] <= shark_size) {
						visited[nr][nc]  = true;
						int nd = cur.dist + 1;
						
						if(map[nr][nc] > 00 && map[nr][nc] < shark_size) {
							fishes.add(new Pair(nr, nc, nd));
							minDist = nd;
						}
						
						q.add(new Pair(nr, nc, nd));
					}
				}
			}
		}
		
		return fishes.isEmpty() ? null : fishes.poll();
	}
	
	static boolean isVailed(int r, int c) {
		return(r>=0 && r<N && c>=0 && c<N);
	}
	
	static void eatFish(Pair target) {
		 map[target.r][target.c] = 0;
		 
		shark_r = target.r;
		shark_c = target.c;
		answer += target.dist;
		
		fish_cnt++;
		if(shark_size == fish_cnt) {
			shark_size++;
			fish_cnt = 0;
		}
	}
}
