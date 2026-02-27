import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String title = br.readLine();
			
			if(map.containsKey(title)) {
				map.put(title, map.get(title)+1);
			} else {
				map.put(title, 1);
			}
		}
		
		int max = 0;
		ArrayList<String> list = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() >= max) {
				max = entry.getValue();
			}
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() == max) {
				list.add(entry.getKey());
			}
		}
		
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}
