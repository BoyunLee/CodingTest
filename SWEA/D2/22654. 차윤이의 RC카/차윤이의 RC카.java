import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int sr = 0;
		int sc = 0;
		for(int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			for(int i=0; i<N; i++) {
				String Line = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = Line.charAt(j);
					if(map[i][j] == 'X') {
						sr = i;
						sc = j;
					}
				}
			}
			
			int[] dr = {1, 0, -1, 0};
			int[] dc = {0, 1, 0, -1};
			
			int Q = Integer.parseInt(br.readLine());
			for(int i=0; i<Q; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());
				String commands = st.nextToken();
				int cr = sr;
				int cc = sc;
				int dir = 2;
				for(char command : commands.toCharArray()) {
					if(command == 'R') {
						dir = (dir + 3) % 4;
					} else if(command == 'L') {
						dir = (dir + 1) % 4;
					} else if(command == 'A') {
						int nr = cr+dr[dir];
						int nc = cc+dc[dir];
						
						if(nr>=0 && nr<N && nc>=0 && nc<N) {
							if(map[nr][nc] != 'T') {
								cr = nr;
								cc = nc;
							}
						}
					}
				}
				if(map[cr][cc] == 'Y') {
					sb.append(1).append(" ");
				} else {
					sb.append(0).append(" ");
				}
			}
			System.out.println("#"+t+" "+sb.toString().trim());
		}
	}
}
