import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static char[][] map;
	static int sr;
	static int sc;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static Queue<int[]> waterQueue;
	static Queue<int[]> queue;
	static int time;

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		waterQueue = new ArrayDeque<>();
		queue = new ArrayDeque<>();
		
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				char c = line.charAt(j);
				map[i][j] = c;
				if(c == '*') {
					waterQueue.add(new int[] {i, j});
				} else if(c == 'S') {
					sr = i;
					sc = j;
				} 
			}
		}
		bfs(sr, sc);
	}
	
	static void fillWather() {
		int wSize = waterQueue.size();
		
		for (int i = 0; i < wSize; i++) {
            int[] w = waterQueue.poll();
            int r = w[0], c = w[1];
            
            for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr>=0 && nr<R && nc>=0 && nc<C) {
					if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
                        map[nr][nc] = '*';
                        waterQueue.add(new int[]{nr, nc});
                    }
				}
			}
		}
	}
	
	static void bfs(int x, int y) {
		visited[x][y] = true;
		queue.add(new int[] {x, y});
		
		time = 0;
		
		while(!queue.isEmpty()) {
			
			fillWather();
			
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				int[] cur = queue.poll();
				int r = cur[0];
				int c = cur[1];
				
				for(int d=0; d<4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					
					if(nr>=0 && nr<R && nc>=0 && nc<C) {
						if(map[nr][nc] == 'D') {
							System.out.println(time+1);
							return;
						}
						
						if (map[nr][nc] == '.' && !visited[nr][nc]) {
	                        visited[nr][nc] = true;
	                        queue.add(new int[]{nr, nc});
	                    }
					}
				}
			}
			time++;
		}
		System.out.println("KAKTUS");
	}
}
