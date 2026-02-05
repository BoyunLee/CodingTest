import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] visited;
	static ArrayList<int[]> list;
	static ArrayList<int[]> boom;
	static ArrayDeque<int[]> queue;
	static int answer;

	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[12][6];
		for(int i=0; i<12; i++) {
			String line = br.readLine();
			for(int  j=0; j<6; j++) {
				char c = line.charAt(j);
				switch (c) {
			    case 'R':
			    	map[i][j] = 1;
			        break;
			    case 'G':
			    	map[i][j] = 2;
			        break;
			    case 'B':
			    	map[i][j] = 3;
			        break;
			    case 'P':
			    	map[i][j] = 4;
			        break;
			    case 'Y':
			    	map[i][j] = 5;
			        break;
			    default:
			    	map[i][j] = 0;
				}
			}
		}
		
		answer = 0;
		while(true) {
			visited = new boolean[12][6];
			boom = new ArrayList<>();
			
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(!visited[i][j] && map[i][j] != 0) {
						list = new ArrayList<>();
						queue = new ArrayDeque<>();
						match(i, j, map[i][j]);
						if(list.size() >= 4) {
							boom.addAll(list);
						}
					}
				}
			}
			
			if(boom.isEmpty()) {
				break;
			}
			
			remove();
			move();	
		}
		System.out.println(answer);
	}
	
	static void match(int r, int c, int color) {
		queue.add(new int[]{r, c});
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
		    int[] cur = queue.poll();
		    list.add(cur);
		
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr>=0 && nr<12 && nc>=0 && nc<6) {
					if(!visited[nr][nc] && map[nr][nc] == color) {
						queue.add(new int[]{nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
	
	static void remove() {
		answer++;
		for(int[] temp : boom) {
			map[temp[0]][temp[1]] = 0;
		}
	}
	
	static void move() {
		for(int c=0; c<6; c++) {
			int bottom = 11;
			
			for(int r=11; r>=0; r--) {
				if(map[r][c] != 0) {
					map[bottom][c] = map[r][c];
					if(bottom != r) {
						map[r][c] = 0;
					}
					bottom--;
				}
			}
		}
	}
}