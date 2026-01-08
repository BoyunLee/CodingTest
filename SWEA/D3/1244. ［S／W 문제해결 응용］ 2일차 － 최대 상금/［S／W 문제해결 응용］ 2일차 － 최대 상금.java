import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int K;
    static int maxNumber;
    static boolean[][] visited;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String num = sc.next();
            K = sc.nextInt();
            
            maxNumber = 0;
            visited = new boolean[K + 1][1000000];

            dfs(0, num);

            System.out.println("#" + test_case + " " + maxNumber);
		}
	}
    
	static void dfs(int cnt, String cur) {
        int value = Integer.parseInt(cur);

        if (visited[cnt][value]) return;
        visited[cnt][value] = true;

        if (cnt == K) {
            maxNumber = Math.max(maxNumber, value);
            return;
        }

        char[] arr = cur.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                dfs(cnt + 1, new String(arr));

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}