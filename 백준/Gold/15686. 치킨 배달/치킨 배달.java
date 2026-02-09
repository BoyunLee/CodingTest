import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static List<int[]> chicken;
	static List<int[]> house;
	static int answer;
	static int[][] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house.add(new int[] {i, j});
				} else if(map[i][j] == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		
		if(chicken.size() <= M) {
			selected = new int[chicken.size()][2];
			for (int i = 0; i < chicken.size(); i++) {
		        selected[i] = chicken.get(i);
		    }
			distance(selected);
		} else {
			selected = new int[M][2];
			subset(0, 0);
		}
		
		System.out.println(answer);
	}
	
	static void distance(int[][] selected) {
		int sum = 0;
		
		for(int[] h : house) {
			int result = Integer.MAX_VALUE;
			for(int[] c : selected) {
				int temp = Math.abs(h[0]-c[0]) +  Math.abs(h[1]-c[1]);
				result = Math.min(result, temp);
			}
			sum += result;
		}
		answer = Math.min(answer, sum);
	}
	
	static void subset(int idx, int start) {
		if(idx == M) {
			distance(selected);
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			selected[idx] = chicken.get(i); 
			subset(idx+1, i+1);
		}
	}
}