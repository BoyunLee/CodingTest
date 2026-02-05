import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int N;
	static int H;
	static int[][][] box;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	static int day;
	static ArrayDeque<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[N][M][H];
		queue = new ArrayDeque<>();
		
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					box[i][j][h] = Integer.parseInt(st.nextToken());
					if(box[i][j][h] == 1) {
						queue.add(new int[] {i, j, h});
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(box[nr][nc][temp[2]] == 0) {
						box[nr][nc][temp[2]] = box[temp[0]][temp[1]][temp[2]] + 1;
						queue.add(new int[] {nr, nc, temp[2]});
					}
				}
			}
			
			int uh = temp[2] + 1;
			int dh = temp[2] - 1;
			if(uh<H && box[temp[0]][temp[1]][uh] == 0) {
				box[temp[0]][temp[1]][uh] = box[temp[0]][temp[1]][temp[2]] + 1;
				queue.add(new int[] {temp[0], temp[1], uh});
			}
			if(dh>=0 && box[temp[0]][temp[1]][dh] == 0) {
				box[temp[0]][temp[1]][dh] = box[temp[0]][temp[1]][temp[2]] + 1;
				queue.add(new int[] {temp[0], temp[1], dh});
			}		
		}
		
		day = 0;
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(box[i][j][h] == 0) {
						System.out.println(-1);
	                    return;
					}
					day = Math.max(day, box[i][j][h]);
				}
			}
		}
		System.out.println(day - 1);
	}
}