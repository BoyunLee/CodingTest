import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();

        int[] result = new int[M];
        boolean[] used = new boolean[N + 1];

        backtrack(N, M, 0, result, used);
        
        System.out.print(sb.toString());
    }

    public static void backtrack(int N, int M, int depth, int[] result, boolean[] used) {
    	if (depth == M) {
    	    for (int i = 0; i < M; i++) {
    	        sb.append(result[i]).append(' ');
    	    }
    	    sb.append('\n');
    	    return;
    	}
    	
        for (int i = 1; i <= N; i++) {
            if (!used[i]) {  
                used[i] = true;
                result[depth] = i;
                backtrack(N, M, depth + 1, result, used);
                used[i] = false;
            }
        }
    }
}