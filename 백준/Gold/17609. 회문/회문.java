import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static char[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String Line = br.readLine();
			int L = Line.length();
			list = new char[L];
			
			for(int j=0; j<L; j++) {
				list[j] = Line.charAt(j);
			}	
		
			int s = 0;
			int e = L-1;
			int cnt = 0;
			boolean right = false;
			boolean left = false;
			
			while(s < e) {
				if(list[s] == list[e]) {
					s++;
					e--;
				} else {
					cnt++;
					if((list[s+1] == list[e]) && (list[s] == list[e-1])) {
						right = check(s+1, e);
						left = check(s, e-1);
						break;
					} else {
						if(list[s+1] == list[e]) {
							right = check(s+1, e);
							break;
						} else if(list[s] == list[e-1]) {
							left = check(s, e-1);
							break;
						}
					}
					break;
				}
			}
			if(cnt == 0) {
				System.out.println(0);
			} else {
				if(right || left) {
					System.out.println(1);
				} else {
					System.out.println(2);
				}
			}
		}
		
	}
	
	static boolean check(int s, int e) {
		while(s < e) {
			if(list[s] == list[e]) {
				s++;
				e--;
			} else {
				return false;
			}
		}
		return true;
	}
}
