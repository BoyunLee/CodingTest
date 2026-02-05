import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	static boolean[] nums;
	static int[] gArr;
	static int[] iArr;
	static boolean[] selected;
	static int win;
	static int lose;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			gArr = new int[9];
			iArr = new int[9];
			nums = new boolean[19];
			win = 0;
			lose = 0;
			selected = new boolean[9];
			
			for(int i=0; i<9; i++) {
				gArr[i] = Integer.parseInt(st.nextToken());
				nums[gArr[i]] = true;
			}
			
			int index = 0;
			for(int i=1; i<=18; i++) {
				if(!nums[i]) {
					iArr[index] = i;
					index++;
				}
			}
			
			permutation(0, 0, 0);
			
			System.out.println("#"+t+" "+win+" "+lose);
		}
	}
	
	static void permutation(int cnt, int gScore, int iScore) {
		
		if(cnt==9) {
			if(gScore > iScore) ++win;
			else ++lose;
			
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			int sum = gArr[cnt] + iArr[i];
			int diff = gArr[cnt] - iArr[i];
			permutation(cnt+1, diff>0 ? gScore+sum:gScore, diff<0 ? iScore+sum:iScore);
			selected[i] = false;
		}
	}
}