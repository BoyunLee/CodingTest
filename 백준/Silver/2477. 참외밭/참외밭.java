import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		int MaxX = 0;
		int MaxY = 0;
		int MinX = Integer.MAX_VALUE;
		int MinY = Integer.MAX_VALUE;
		int MaxXindex = 0;
		int MaxYindex = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] len = new int[6]; 
		StringTokenizer st = null;
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
			
			if(d==1||d==2) {
				if(MaxX < len[i]) {
					MaxXindex = i;
					MaxX = len[i];
				}
			} else if(d==3||d==4) {
				if(MaxY < len[i]) {
					MaxYindex = i;
					MaxY = len[i];
				}
			}
			MinX = Math.abs(len[(MaxYindex-1+6)%6] - len[(MaxYindex+1+6)%6]);
			MinY = Math.abs(len[(MaxXindex-1+6)%6] - len[(MaxXindex+1+6)%6]);
		}
		
		System.out.println(((MaxX*MaxY)-(MinX*MinY))*N);
	}
}