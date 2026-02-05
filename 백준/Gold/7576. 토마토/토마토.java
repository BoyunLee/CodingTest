import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int N;
	static int[][] box;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	static int day;
	static ArrayDeque<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		queue = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					queue.add(new int[] {i, j});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(box[nr][nc] == 0) {
						box[nr][nc] = box[temp[0]][temp[1]] + 1;
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
		
		day = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0) {
					System.out.println(-1);
                    return;
				}
				day = Math.max(day, box[i][j]);
			}
		}
		System.out.println(day - 1);
	}
}