import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[] order = new int[9];;
	static boolean[] used = new boolean[9];
	static int maxScore;

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 
		 arr = new int[N][9];
		 for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			  for(int j=0; j<9; j++) {
				  arr[i][j] = Integer.parseInt(st.nextToken());
			  }
		 }

		 order[3] = 0;
		 used[0] = true;

		 makeOrder(0);
		 
		 System.out.println(maxScore);
	}
	
	static void makeOrder(int idx) {
		if(idx == 3) {
			makeOrder(idx+1);
			return;
		}
		
		if(idx == 9) {
			play();
			return;
		}
		
		for(int p=1; p<9; p++) {
			if(!used[p]) {
				used[p] = true;
				order[idx] = p;
				makeOrder(idx+1);
				used[p] = false;
			}
		}
	}
	
	static void play() {
		int score = 0;
        int hitterIdx = 0;
        
        for(int inning=0; inning<N; inning++) {
        	int out = 0;
        	boolean[] base = new boolean[3];
        	
        	while(out<3) {
        		int player = order[hitterIdx];
        		int result = arr[inning][player];
        		
        		if(result == 0) {
        			out++;
        		} else if(result == 4) {
        			score++;
        			for(int i=0; i<3; i++) {
        				if(base[i]) {
        					score++;
        					base[i] = false;
        				}
        			}
        		} else {
        			for(int i=2; i>=0; i--) {
        				if(base[i]) {
        					if(i+result >= 3) {
        						score++;
        					} else {
        						base[i+result] = true;
        					}
        					base[i] = false;
        				}
        			}
        			base[result-1] = true;
        		}
        		hitterIdx = (hitterIdx+1)%9;
        	}
        }
        maxScore = Math.max(maxScore, score);
	}
}
