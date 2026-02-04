import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int cnt = 0;
		int i=0;
		int j=0;
		ArrayList<Integer> list = new ArrayList<>();
		
		while(true) {
			if(sum<S) {
                if(j == N) break;
				sum += arr[j];
				j++;
				cnt++;
			} else if(sum>=S) {
				list.add(cnt);
				sum -= arr[i];
				i++;
				cnt--;
			}
		}
		
		Collections.sort(list);
		
		if(list.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(list.get(0));
		}
	}
}