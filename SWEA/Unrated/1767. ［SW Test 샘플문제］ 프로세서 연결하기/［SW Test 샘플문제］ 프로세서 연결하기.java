import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
	
	static int N;
	static int M;
	static int[][] map;
	static ArrayList<int[]> cores;
	
	static int Maxcore;
	static int Minwire;
	
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			cores = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                        cores.add(new int[]{i, j});
                    }
				}
			}
			
			Maxcore = 0;
			Minwire = Integer.MAX_VALUE;
			M = cores.size();
			
			dfs(0, 0, 0);
			
			System.out.println("#" + t + " " + Minwire);
		}
	}
	
	static void dfs(int idx, int core, int wire) {
		if(idx == cores.size()) {
			if(core > Maxcore) {
				Maxcore = core;
				Minwire = wire;
			} else if(core == Maxcore) {
				Minwire = Math.min(Minwire, wire);
			}
			return;
		}
		
		if(core+M-idx < Maxcore) {
			return;
		}
		
		int r = cores.get(idx)[0];
		int c = cores.get(idx)[1];
		
		for(int d=0; d<4; d++) {
			boolean sucess = false;
			ArrayList<int[]> list = new ArrayList<>();
			
			int nr = r;
			int nc = c;
			int len = 0;
			
			while(true) {
				nr += dr[d];
				nc += dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(map[nr][nc] == 0) {
						sucess = true;
						list.add(new int[] {nr, nc});
						len++;
					} else {
						sucess = false;
						break;
					}
				} else {
					break;
				}
			}
			
			if(sucess) {
				nr = r;
				nc = c;
				for (int i = 0; i < len; i++) {
                    nr += dr[d];
                    nc += dc[d];
                    map[nr][nc] = 2;
                }
				
				dfs(idx+1, core+1, wire+len);
				
				nr = r;
				nc = c;
				for (int i = 0; i < len; i++) {
                    nr += dr[d];
                    nc += dc[d];
                    map[nr][nc] = 0;
                }
			}
		}		
		dfs(idx+1, core, wire);
	}
}