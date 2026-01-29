import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C;
	static int[][] maps;
	static int max;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        maps = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] cs = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(cs[j]=='x') {
                	maps[i][j] = 1;
                }
            }
        }
        
        max = 0;
        for(int i=0; i<R; i++) {
        	if(maps[i][0] == 0) {
        		maps[i][0] = 2;
        		if(goGas(i, 0)) { 
        			max++;
    			}
        	}
        }
        
        System.out.println(max);
	}
	
	static boolean goGas(int r, int c) {
		for(int d=0; d<3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			
			if(maps[nr][nc] == 0) {
				if(nc == C-1) {
					return true;
				}
				
				maps[nr][nc] = 2;
				if(goGas(nr, nc)) return true;
			}
		}
		return false;
	}
}